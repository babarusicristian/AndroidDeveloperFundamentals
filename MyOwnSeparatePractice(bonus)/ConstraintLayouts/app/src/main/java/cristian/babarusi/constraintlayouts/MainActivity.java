package cristian.babarusi.constraintlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewSus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewSus = findViewById(R.id.textview_sus);
        //used unicode for displaying romania flag
        mTextViewSus.setText(MessageFormat.format("{0} {1}" , getString(R.string.addicted), "\uD83C\uDDEE\uD83C\uDDEA"));
    }
}
