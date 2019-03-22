package cristian.babarusi.module8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cristian.babarusi.module8.challenge1.Challenge1Activity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button mButtonChallenge1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mButtonChallenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge1Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mButtonChallenge1 = findViewById(R.id.button_challenge_1);
    }
}
