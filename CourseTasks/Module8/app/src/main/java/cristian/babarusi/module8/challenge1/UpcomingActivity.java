package cristian.babarusi.module8.challenge1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cristian.babarusi.module8.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpcomingActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    private TheMovieDatabaseApi mTheMovieDatabaseApi;
    private TextView mTextViewDisplayUpcoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);

        initView();
        getUpcomingMoviesTotalPages();
        getUpcomingMovies();
    }

    private void initView() {
        //our instance of retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Challenge1Activity.MY_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mTextViewDisplayUpcoming = findViewById(R.id.text_view_display_upcoming_movies);
    }

    private void getUpcomingMoviesTotalPages() {
        mTheMovieDatabaseApi = mRetrofit.create(TheMovieDatabaseApi.class);

        Call<MovieModel> call = mTheMovieDatabaseApi.getUpcomingTotalPages(Challenge1Activity.MY_API_KEY,
                Challenge1Activity.MY_LANGUAGE, 1);
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(UpcomingActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                MovieModel movieModelTotalPages = response.body();
                //retrieve "total_pages"
                int totPag = movieModelTotalPages.getTotalPages();
                Toast.makeText(UpcomingActivity.this, "Upcoming total pages: " + totPag, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                //if there is any errors, display them in our text view
                Toast.makeText(UpcomingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUpcomingMovies() {
        mTextViewDisplayUpcoming.setText("");

        mTheMovieDatabaseApi = mRetrofit.create(TheMovieDatabaseApi.class);

        Call<MovieModelList> call =
                mTheMovieDatabaseApi.getUpcoming(Challenge1Activity.MY_API_KEY,
                        Challenge1Activity.MY_LANGUAGE, 1); //parametrii de la api interface (query)
        call.enqueue(new Callback<MovieModelList>() {
            @Override
            public void onResponse(Call<MovieModelList> call, Response<MovieModelList> response) {
                if (!response.isSuccessful()) {
                    mTextViewDisplayUpcoming.setText("Code: " + response.code());
                    return;
                }

                //now start to retrive and display data into our text view
                MovieModelList movieModelListTopRated = response.body(); //body is specific to
                // response, not to our Api

                //in out api the fields are named: title, id, popularity, video and others :)
                //in my case i use only the title field
                for (MovieModel movieModel : movieModelListTopRated.getMovieModelList()) {
                    String content = "";
                    content += movieModel.getTitle() + "\n";
                    mTextViewDisplayUpcoming.append(content); //append = to add to the already
                    // text inserted there
                }
            }

            @Override
            public void onFailure(Call<MovieModelList> call, Throwable t) {
                //if there is any errors, display them in our text view
                mTextViewDisplayUpcoming.setText(t.getMessage());
            }
        });
    }
}
