package cristian.babarusi.module5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonChallenge1;
    private Button mButtonChallenge3;
    private Button mButtonChallenge4;
    private Button mButtonChallenge5;
    private Button mButtonChallenge6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mButtonChallenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=cristian.babarusi.guessthenumber"));
                startActivity(intent);
            }
        });

        mButtonChallenge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, Challenge3Activity.class);
                startActivity(intent3);
            }
        });

        mButtonChallenge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, FirstChallenge4Activity.class);
                startActivity(intent4);
            }
        });

        mButtonChallenge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity.this, Challenge5Activity.class);
                startActivity(intent5);
            }
        });

        mButtonChallenge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(MainActivity.this, Challenge6Activity.class);
                startActivity(intent6);
            }
        });
    }

    private void initView() {
        mButtonChallenge1 = findViewById(R.id.button_challenge1);
        mButtonChallenge3 = findViewById(R.id.button_challenge3);
        mButtonChallenge4 = findViewById(R.id.button_challenge4);
        mButtonChallenge5 = findViewById(R.id.button_challenge5);
        mButtonChallenge6 = findViewById(R.id.button_challenge6);
    }
}
