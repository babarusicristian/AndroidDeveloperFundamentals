package cristian.babarusi.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logging.show(MainActivity.this, "The class is working fine, no errors.");
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }
}
