package cristian.babarusi.module5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Challenge3Activity extends AppCompatActivity {

    static final String DATA_FROM_ACT3 = "dataFromActivityThree";

    private Button mButtonTextOne;
    private Button mButtonTextTwo;
    private Button mButtonTextThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge3);

        initView();

        mButtonTextOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOne = new Intent(Challenge3Activity.this, ScrollViewActivity.class);
                intentOne.putExtra(DATA_FROM_ACT3, "one");
                startActivity(intentOne);

            }
        });

        mButtonTextTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwo = new Intent(Challenge3Activity.this, ScrollViewActivity.class);
                intentTwo.putExtra(DATA_FROM_ACT3, "two");
                startActivity(intentTwo);

            }
        });

        mButtonTextThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThree = new Intent(Challenge3Activity.this, ScrollViewActivity.class);
                intentThree.putExtra(DATA_FROM_ACT3, "three");
                startActivity(intentThree);
            }
        });
    }

    private void initView() {
        mButtonTextOne = findViewById(R.id.button_text_one);
        mButtonTextTwo = findViewById(R.id.button_text_two);
        mButtonTextThree = findViewById(R.id.button_text_three);
    }
}
