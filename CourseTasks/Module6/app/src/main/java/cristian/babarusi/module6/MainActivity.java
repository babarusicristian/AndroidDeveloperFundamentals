package cristian.babarusi.module6;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_FRAGMENT_MANUAL_DATA = "keyFragmentManualData";
    public static final String KEY_INTENT_DATA = "keyIntentData";

    public static final String DATA_FOR_ACTIVITY = "dataForActivity";
    public static final String DATA_FOR_FRAGMENT = "dataForFragment";

    private Button mButtonChallenge3;
    private LinearLayout mLinearLayoutTheLayout;
    private ConstraintLayout mConstraintLayoutAllLayout;
    private Button mButtonSendDatas;
    private EditText mEditTextDataToActivity;
    private EditText mEditTextDataToFragment;
    private Button mButtonCodeChallenge6;
    private Button mButtonCodeChallenge4;
    private Button mButtonCodeChallenge5;
    private Button mButtonCodeChallenge8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mButtonChallenge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WithFragmentsActivity.class);
                //send manual data directly to the fragment
                Bundle bundle34 = new Bundle();
                bundle34.putString(KEY_FRAGMENT_MANUAL_DATA, "AUTOMATIC TEXT sended from other activity (MainActivity)" +
                        " directly to this fragment that is contained in this activity (WithFragmentsActivity)" +
                        "\n\n + life cycle of activity" +
                        "\n\n + life cycle of fragment");
                MyFragment.getInstance().setArguments(bundle34);
                MyFragment.getInstance().setBehavior("manual");
                //send manual data to the activity
                intent.putExtra(KEY_INTENT_DATA, "AUTOMATIC TITLE sended from another activity to this activity");
                startActivity(intent);
            }
        });

        mLinearLayoutTheLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loseFocus(v);
            }
        });

        mConstraintLayoutAllLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loseFocus(v);
            }
        });

        mButtonSendDatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextDataToActivity.getText().toString().isEmpty()) {
                    mEditTextDataToActivity.setError(getString(R.string.required));
                    mEditTextDataToActivity.requestFocus();
                } else if (mEditTextDataToFragment.getText().toString().isEmpty()) {
                    mEditTextDataToFragment.setError(getString(R.string.required));
                    mEditTextDataToFragment.requestFocus();
                } else {
                    loseFocus(v);
                    Intent intent = new Intent(MainActivity.this, WithFragmentsActivity.class);
                    //send data to the fragment
                    Bundle bundle = new Bundle();
                    bundle.putString(DATA_FOR_FRAGMENT, mEditTextDataToFragment.getText().toString());
                    MyFragment.getInstance().setArguments(bundle);
                    MyFragment.getInstance().setBehavior("custom");
                    //send data to the activity
                    intent.putExtra(DATA_FOR_ACTIVITY, mEditTextDataToActivity.getText().toString());
                    startActivity(intent);
                }
            }
        });

        mButtonCodeChallenge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge4Activity.class);
                startActivity(intent);
            }
        });

        mButtonCodeChallenge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge5Activity.class);
                startActivity(intent);
            }
        });

        mButtonCodeChallenge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CodeChallenge6and7Activity.class);
                startActivity(intent);
            }
        });

        mButtonCodeChallenge8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Challenge8Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mButtonChallenge3 = findViewById(R.id.button_code_challenge_3);
        mLinearLayoutTheLayout = findViewById(R.id.the_layout);
        mConstraintLayoutAllLayout = findViewById(R.id.all_layout);
        mButtonSendDatas = findViewById(R.id.button_send_datas);
        mEditTextDataToActivity = findViewById(R.id.edit_text_pass_to_activity);
        mEditTextDataToFragment = findViewById(R.id.edit_text_pass_to_fragment);
        mButtonCodeChallenge6 = findViewById(R.id.button_code_challenge_6);
        mButtonCodeChallenge4 = findViewById(R.id.button_code_challenge_4);
        mButtonCodeChallenge5 = findViewById(R.id.button_code_challenge_5);
        mButtonCodeChallenge8 = findViewById(R.id.button_code_challenge_8);
    }

    private void loseFocus(View v) {
        mLinearLayoutTheLayout.requestFocus();
        hideKeyboard(v);
    }
    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
