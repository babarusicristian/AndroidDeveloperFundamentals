package cristian.babarusi.module3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.regex.Pattern;

public class CodeChallenge1Activity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private CheckBox mCheckBoxTerms;
    private Button mButtonSubmit;
    private TextView mTextViewInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_challenge1);

        initView();

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verificationAndValidation(v);
            }
        });
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edittex_email);
        mEditTextEmail.setFocusableInTouchMode(true);
        mEditTextPhone = findViewById(R.id.edittext_phone);
        mEditTextPhone.setFocusableInTouchMode(true);
        mCheckBoxTerms = findViewById(R.id.checkbox_terms);
        mButtonSubmit = findViewById(R.id.button_submit);
        mTextViewInformation = findViewById(R.id.textview_information);
        mTextViewInformation.setFocusableInTouchMode(true);
    }

    //check if is a valid email address
    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public void closeKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void verificationAndValidation(View view) {

        //required EditTexs
        if (mEditTextEmail.getText().toString().equals(null) || mEditTextEmail.getText().toString().isEmpty()) {
            mEditTextEmail.setError(getString(R.string.fil_email_address));
            mEditTextEmail.requestFocus();
            mTextViewInformation.setText("");
            return;
        }

        if (mEditTextPhone.getText().toString() == null || mEditTextPhone.getText().toString().isEmpty()) {
            mEditTextPhone.setError(getString(R.string.fill_phone_number));
            mEditTextPhone.requestFocus();
            mTextViewInformation.setText("");
            return;
        }
        //END required EditTexts

        //accept term required
        if (!mCheckBoxTerms.isChecked()) {
            Toast.makeText(CodeChallenge1Activity.this, getString(R.string.you_must_accept_terms), Toast.LENGTH_SHORT).show();
            mTextViewInformation.setText("");
            mCheckBoxTerms.requestFocus();
            closeKeyboard(view);
            return;
        }

        //email validation
        if (validEmail(mEditTextEmail.getText().toString())) {
            mTextViewInformation.setText(MessageFormat.format("{0}: {1}\n{2}: {3}\n{4}: {5}",
                    getString(R.string.email),
                    mEditTextEmail.getText().toString(),
                    getString(R.string.phone),
                    mEditTextPhone.getText().toString(),
                    getString(R.string.terms),
                    mCheckBoxTerms.isChecked()));
            mTextViewInformation.requestFocus();
            closeKeyboard(view);

        } else {
            mEditTextEmail.setError(getString(R.string.email_error_validation));
            mEditTextEmail.requestFocus();
        }
    }
}

