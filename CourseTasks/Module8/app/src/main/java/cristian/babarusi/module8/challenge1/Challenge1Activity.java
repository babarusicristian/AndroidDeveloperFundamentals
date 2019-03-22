package cristian.babarusi.module8.challenge1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cristian.babarusi.module8.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Challenge1Activity extends AppCompatActivity {

    public static final String MY_API_KEY = "577bb7e3f12eac588b64e9b373f8f2ee";
    public static final String MY_BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String MY_LANGUAGE = "en-US";

    private Button mButtonTopRatedMovies;
    private Button mButtonUpcomingMovies;
    private Button mButtonNowPlayingMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge1);

        initView();

        mButtonTopRatedMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Challenge1Activity.this, TopRatedActivity.class);
                startActivity(intent);
            }
        });

        mButtonUpcomingMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Challenge1Activity.this, UpcomingActivity.class);
                startActivity(intent);
            }
        });
        mButtonNowPlayingMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Challenge1Activity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mButtonTopRatedMovies = findViewById(R.id.button_top_rated_movies);
        mButtonUpcomingMovies = findViewById(R.id.button_upcoming_movies);
        mButtonNowPlayingMovies = findViewById(R.id.button_now_playing_movies);
    }
}
