package cristian.babarusi.module5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ScrollViewActivity extends AppCompatActivity {

    private TextView mTextViewDisplayContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        initView();

        //receive and display data...
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            if (extras.getString(Challenge3Activity.DATA_FROM_ACT3).equals("one")) {
                mTextViewDisplayContent.setText(getString(R.string.paragraph1));
            } else if (extras.getString(Challenge3Activity.DATA_FROM_ACT3).equals("two")) {
                mTextViewDisplayContent.setText(getString(R.string.paragraph2));
            } else {
                mTextViewDisplayContent.setText(getString(R.string.paragraph3));
            }
        }
    }

    private void initView() {
        mTextViewDisplayContent = findViewById(R.id.textview_display_content);
    }
}
