package cristian.babarusi.traveljournalhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonManageTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mButtonManageTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentManageTrip = new Intent(MainActivity.this, ManageTripActivity.class);
                startActivity(intentManageTrip);
            }
        });
    }

    private void initViews() {
        mButtonManageTrip = findViewById(R.id.button_manage_trip);
    }
}
