package cristian.babarusi.module8.challenge1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cristian.babarusi.module8.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopRatedActivity extends AppCompatActivity {

    private static final String MY_API_KEY = "577bb7e3f12eac588b64e9b373f8f2ee";
    private static final String MY_BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static final String MY_LANGUAGE = "en-US";


    private Retrofit mRetrofit;
    private TheMovieDatabaseApi mTheMovieDatabaseApi;

    private TextView mTextViewDisplayTopRated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);

        initView();
        getTopRatedMovies();
    }

    private void initView() {
        //our instance of retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(MY_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mTextViewDisplayTopRated = findViewById(R.id.text_view_display_top_rated_movies);
    }

    private void getTopRatedMovies() {
        mTextViewDisplayTopRated.setText("");

        mTheMovieDatabaseApi = mRetrofit.create(TheMovieDatabaseApi.class);

        Call<List<TitlesList>> call = mTheMovieDatabaseApi.getTopRated(MY_API_KEY, MY_LANGUAGE, 1);
        call.enqueue(new Callback<List<TitlesList>>() {
            @Override
            public void onResponse(Call<List<TitlesList>> call, Response<List<TitlesList>> response) {
                if (!response.isSuccessful()) {
                    mTextViewDisplayTopRated.setText("Code: " + response.code());
                    return;
                }

                //now start to retrive and display data into our text view
                List<TitlesList> topRatedMoviesList = response.body(); //body is specific to response, not to our Api

                //in out api the fields are named: title, id, popularity, video and others :)
                //in my case i use only the title field
                for (TitlesList title : topRatedMoviesList) {
                    String content = "";
                    content += "title: " + title.getTitlesList() + "\n";
                    mTextViewDisplayTopRated.append(content); //append = to add to the already text inserted there
                }
            }

            @Override
            public void onFailure(Call<List<TitlesList>> call, Throwable t) {
                //if there is any errors, display them in our text view
                mTextViewDisplayTopRated.setText(t.getMessage());
            }
        });
    }
}
