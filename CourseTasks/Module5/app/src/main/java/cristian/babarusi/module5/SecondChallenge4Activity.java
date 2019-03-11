package cristian.babarusi.module5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondChallenge4Activity extends AppCompatActivity {

    public static final String DATA_MESSAGE = "dataMessage";

    private Button mButtonSend;
    private EditText mEditTextMessage;
    private TextView mTextViewDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_challenge4);

        //back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initView();

        //receiving message from another activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mTextViewDisplayMessage.setText(bundle.getString(FirstChallenge4Activity.DATA_MESSAGE));
        }

        //send back reply message and close this activity
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextMessage.getText().toString().isEmpty()
                || mEditTextMessage.getText().toString().equals("")) {
                    mEditTextMessage.setError(getString(R.string.please_fill_a_message));
                } else {
                    Intent intentAct1 = new Intent(SecondChallenge4Activity.this, FirstChallenge4Activity.class);
                    intentAct1.putExtra(DATA_MESSAGE, mEditTextMessage.getText().toString());
                    setResult(RESULT_OK, intentAct1);
                    finish();
                }
            }
        });
    }

    private void initView() {
        mButtonSend = findViewById(R.id.button_act2_send);
        mEditTextMessage = findViewById(R.id.edittext_act2_message);
        mTextViewDisplayMessage = findViewById(R.id.text_view_act2_display_message);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intentAct1 = new Intent(SecondChallenge4Activity.this, FirstChallenge4Activity.class);
        intentAct1.putExtra(DATA_MESSAGE, "");
        setResult(RESULT_OK, intentAct1);
        finish();
        return true;
    }
}
