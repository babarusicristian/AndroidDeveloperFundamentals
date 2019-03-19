package cristian.babarusi.module7;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonChallenge1;
    private Button mButtonChallenge2;
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
                Intent intent = new Intent(MainActivity.this, Challenge1Activity.class);
                startActivity(intent);
            }
        });

        mButtonChallenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge2Activity.class);
                startActivity(intent);
            }
        });

        mButtonChallenge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new CustomDatePicker();
                newFragment.show(getSupportFragmentManager(), "DatePicker");
            }
        });

        mButtonChallenge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge5Activity.class);
                startActivity(intent);
            }
        });

        mButtonChallenge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge6Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mButtonChallenge1 = findViewById(R.id.button_challenge_1);
        mButtonChallenge2 = findViewById(R.id.button_challenge_2);
        mButtonChallenge3 = findViewById(R.id.button_challenge_3);
        mButtonChallenge4 = findViewById(R.id.button_challenge_4);
        mButtonChallenge5 = findViewById(R.id.button_challenge_5);
        mButtonChallenge6 = findViewById(R.id.button_challenge_6);
    }
}
