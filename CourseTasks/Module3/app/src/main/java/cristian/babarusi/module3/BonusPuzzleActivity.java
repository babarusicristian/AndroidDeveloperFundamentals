package cristian.babarusi.module3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class BonusPuzzleActivity extends AppCompatActivity {

    private View mViewBlueBox;
    private View mViewPinkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_puzzle);

        initView();
    }

    private void initView() {
        mViewBlueBox = findViewById(R.id.view_bluebox);
        mViewPinkBox = findViewById(R.id.view_pinkbox);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        //set size for bluebox view
        int widthBlue = displaymetrics.widthPixels;
        int heightBlue = displaymetrics.heightPixels;

        mViewBlueBox.getLayoutParams().width = widthBlue / 12;
        mViewBlueBox.getLayoutParams().height = heightBlue / 19;

        //set size for pinkbox view
        int widthPink = displaymetrics.widthPixels;
        int heightPink = displaymetrics.heightPixels;

        mViewPinkBox.getLayoutParams().width = widthPink / 24;
        mViewPinkBox.getLayoutParams().height = heightPink / 38;
    }
}
