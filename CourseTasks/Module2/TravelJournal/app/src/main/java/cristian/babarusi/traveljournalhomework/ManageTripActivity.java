package cristian.babarusi.traveljournalhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ManageTripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_trip);
        setTitle(getString(R.string.manage_trip_title));
    }
}
