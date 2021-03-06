package cristian.babarusi.module3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButttonChallenge1;
    private Button mButttonChallenge2;
    private Button mButttonChallenge3;
    private Button mButttonChallenge4;
    private Button mButtonBonusPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mButttonChallenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, CodeChallenge1Activity.class);
                startActivity(intent1);
            }
        });

        mButttonChallenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, CodeChallenge2Activity.class);
                startActivity(intent2);
            }
        });

        mButttonChallenge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, CodeChallenge3Activity.class);
                startActivity(intent3);
            }
        });

        mButttonChallenge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, CodeChallenge4Activity.class);
                startActivity(intent4);
            }
        });

        mButtonBonusPuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity.this, BonusPuzzleActivity.class);
                startActivity(intent5);
            }
        });
    }

    private void initView() {
        mButttonChallenge1 = findViewById(R.id.button_module3_challenge_1);
        mButttonChallenge2 = findViewById(R.id.button_module3_challenge_2);
        mButttonChallenge3 = findViewById(R.id.button_module3_challenge_3);
        mButttonChallenge4 = findViewById(R.id.button_module3_challenge_4);
        mButtonBonusPuzzle = findViewById(R.id.button_module3_bonus_puzzle);
    }
}
