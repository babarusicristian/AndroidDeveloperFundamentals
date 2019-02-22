package cristian.babarusi.module4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonChallenge1;
    private Button mButtonChallenge2;
    private Button mButtonChallenge3;
    private Button mButtonChallenge4;
    private Button mButtonBonus1;
    private Button mButtonBonus2;
    private Button mButtonWithoutBarier;

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

        mButtonChallenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Challenge2Activity.class);
                startActivity(intent2);
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
                Intent intent4 = new Intent(MainActivity.this, Challenge4Activity.class);
                startActivity(intent4);
            }
        });

        mButtonBonus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentB1 = new Intent(MainActivity.this, Bonus1Activity.class);
                startActivity(intentB1);
            }
        });

        mButtonBonus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentB2 = new Intent(MainActivity.this, Bonus2Activity.class);
                startActivity(intentB2);
            }
        });

        mButtonWithoutBarier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentW = new Intent(MainActivity.this, WithoutBarierActivity.class);
                startActivity(intentW);
            }
        });
    }

    private void initView() {
        mButtonChallenge1 = findViewById(R.id.button_challenge1);
        mButtonChallenge2 = findViewById(R.id.button_challenge2);
        mButtonChallenge3 = findViewById(R.id.button_challenge3);
        mButtonChallenge4 = findViewById(R.id.button_challenge4);
        mButtonBonus1 = findViewById(R.id.button_bonus1);
        mButtonBonus2 = findViewById(R.id.button_bonus2);
        mButtonWithoutBarier = findViewById(R.id.button_without_barier);
    }
}
