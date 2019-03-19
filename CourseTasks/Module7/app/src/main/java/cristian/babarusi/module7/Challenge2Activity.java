package cristian.babarusi.module7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import javax.security.auth.login.LoginException;

import cristian.babarusi.module7.utils.Logging;

public class Challenge2Activity extends AppCompatActivity {

    private ImageView mImageViewBattery;
    private Button mButtonPlus;
    private Button mButtonMinus;

    private int level = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge2);

        initView();

        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level--;

                if (level < 1) {
                    level = 1;
                }

                Logging.show(Challenge2Activity.this, "level: " + level);

                switch (level) {
                    case 1:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_1);
                        break;
                    case 2:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_2);
                        break;
                    case 3:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_3);
                        break;
                    case 4:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_4);
                        break;
                    case 5:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_5);
                        break;
                    case 6:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_6);
                        break;
                    case 7:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_7);
                        break;
                }

            }
        });

        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level++;

                if (level > 7) {
                    level = 7;
                }

                Logging.show(Challenge2Activity.this, "level: " + level);

                switch (level) {
                    case 1:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_1);
                        break;
                    case 2:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_2);
                        break;
                    case 3:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_3);
                        break;
                    case 4:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_4);
                        break;
                    case 5:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_5);
                        break;
                    case 6:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_6);
                        break;
                    case 7:
                        mImageViewBattery.setImageResource(R.drawable.ic_battery_7);
                        break;
                }
            }
        });
    }

    private void initView() {
        mImageViewBattery = findViewById(R.id.image_view_battery);
        mButtonPlus = findViewById(R.id.button_plus);
        mButtonMinus = findViewById(R.id.button_minus);
    }
}
