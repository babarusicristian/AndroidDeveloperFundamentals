package cristian.babarusi.module5;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstChallenge4Activity extends AppCompatActivity {

    public static final String DATA_MESSAGE = "dataMessage";
    public static final int CODE_KEY = 200;

    private Button mButtonSend;
    private EditText mEditTextMessage;
    private TextView mTextViewDisplayMessage;
    private TextView mTextViewReplyLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_challenge4);

        initView();

        //sending message to other activity
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextMessage.getText().toString().isEmpty()
                || mEditTextMessage.getText().toString().equals("")) {
                    mEditTextMessage.setError(getString(R.string.please_fill_a_message));
                    mEditTextMessage.requestFocus();
                } else {
                    Intent intentAct2 = new Intent(FirstChallenge4Activity.this, SecondChallenge4Activity.class);
                    intentAct2.putExtra(DATA_MESSAGE, mEditTextMessage.getText().toString());
                    startActivityForResult(intentAct2, CODE_KEY);
                }
            }
        });
    }

    private void initView() {
        mButtonSend = findViewById(R.id.button_act1_send);
        mEditTextMessage = findViewById(R.id.edittext_act1_message);
        mTextViewDisplayMessage = findViewById(R.id.text_view_act1_display_message);
        mTextViewReplyLabel = findViewById(R.id.text_view_reply_label);
    }

    //for receiving data from another intent and to display it
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_KEY && resultCode == Activity.RESULT_OK) {

            String mess = data.getStringExtra(SecondChallenge4Activity.DATA_MESSAGE);
            mTextViewDisplayMessage.setText(mess);
            mEditTextMessage.setText("");

            mTextViewReplyLabel.setVisibility(View.VISIBLE);
            mTextViewDisplayMessage.setVisibility(View.VISIBLE);

        } else  if (resultCode == Activity.RESULT_CANCELED) {
            //errors or something else
        }
    }
}
