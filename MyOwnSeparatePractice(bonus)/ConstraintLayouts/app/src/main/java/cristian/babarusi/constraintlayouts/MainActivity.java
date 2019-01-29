package cristian.babarusi.constraintlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    Button btnCancel;
    TextView txtSus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCancel = findViewById(R.id.buttonCancel);
        txtSus = findViewById(R.id.textViewSus);

        txtSus.setText(MessageFormat.format("{0} {1}" , getString(R.string.addicted), "\uD83C\uDDEE\uD83C\uDDEA"));

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }
}
