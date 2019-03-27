package cristian.babarusi.module9;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import cristian.babarusi.module9.utils.Snack;

public class Challenge1and2Activity extends AppCompatActivity {

    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private CheckBox mCheckBoxAcceptTerms;
    private TextView mTextViewDisplayData;

    private Button mButtonSaveData;
    private Button mButtonClearData;
    private Button mButtonDisplayData;

    //for sharedPreferences
    public static final String SHARED_PREFS = "sharedPrefs";

    public static final String SP_FIRST_NAME = "spFirstName";
    public static final String SP_LAST_NAME = "spLastName";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_PASSWORD = "spPassword";
    public static final String SP_TERMS = "spTerms";

    private String spFirstName = "";
    private String spLastName = "";
    private String spEmail = "";
    private String spPassword = "";
    private boolean spTerms = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge1and2);

        initView();

        mButtonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //for first name
                if (mEditTextFirstName.getText().toString().matches(".*[^a-zA-Z].*")) {
                    mEditTextFirstName.requestFocus();
                    mEditTextFirstName.setError(getString(R.string.first_name_invalid));
                }
                else if (mEditTextFirstName.getText().toString().isEmpty()) {
                    mEditTextFirstName.requestFocus();
                    mEditTextFirstName.setError(getString(R.string.this_field_required));
                }
                else if (mEditTextFirstName.getText().toString().length() < 3) {
                    mEditTextFirstName.requestFocus();
                    mEditTextFirstName.setError(getString(R.string.three_chars_minimum));
                }

                //for last name (space permitted)
                else if (mEditTextLastName.getText().toString().matches(".*[^a-zA-Z\\s].*")) {
                    mEditTextLastName.requestFocus();
                    mEditTextLastName.setError(getString(R.string.last_name_invalid));
                }
                else if (mEditTextLastName.getText().toString().isEmpty()) {
                    mEditTextLastName.requestFocus();
                    mEditTextLastName.setError(getString(R.string.this_field_required));
                }
                else if (mEditTextLastName.getText().toString().length() < 3) {
                    mEditTextLastName.requestFocus();
                    mEditTextLastName.setError(getString(R.string.three_chars_minimum));
                }
                //for email
                else if (mEditTextEmail.getText().toString().isEmpty()) {
                    mEditTextEmail.requestFocus();
                    mEditTextEmail.setError(getString(R.string.this_field_required));
                }

                else if (!validEmail(mEditTextEmail.getText().toString())) {
                    mEditTextEmail.requestFocus();
                    mEditTextEmail.setError(getString(R.string.email_invalid));
                }
                //for password (any chars permitted)
                else if (mEditTextPassword.getText().toString().isEmpty()) {
                    mEditTextPassword.requestFocus();
                    mEditTextPassword.setError(getString(R.string.this_field_required));
                }
                //for terms and conditions
                else if (!mCheckBoxAcceptTerms.isChecked()) {
                    Snack.bar(v, getString(R.string.you_must_accept_terms));
                }
                //save data to sharepref
                else {
                    spFirstName = mEditTextFirstName.getText().toString();
                    spLastName = mEditTextLastName.getText().toString();
                    spEmail = mEditTextEmail.getText().toString();
                    spPassword = mEditTextPassword.getText().toString();
                    spTerms = mCheckBoxAcceptTerms.isChecked();
                    saveDataSharedPref();
                    Toast.makeText(Challenge1and2Activity.this, getString(R.string.data_saved_to_shared_pref), Toast.LENGTH_SHORT).show();
                }

            }
        });

        mButtonClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearDataSharefPref();
                Toast.makeText(Challenge1and2Activity.this, getString(R.string.data_cleared_from_shared_pref), Toast.LENGTH_SHORT).show();
            }
        });

        mButtonDisplayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDataSharePref();
            }
        });
    }

    private void initView() {
        mEditTextFirstName = findViewById(R.id.edit_text_first_name);
        mEditTextLastName = findViewById(R.id.edit_text_last_name);
        mEditTextEmail = findViewById(R.id.edit_text_email);
        mEditTextPassword = findViewById(R.id.edit_text_password);
        mCheckBoxAcceptTerms = findViewById(R.id.check_box_accept_terms);
        mTextViewDisplayData = findViewById(R.id.text_view_display_data);
        mTextViewDisplayData.setText("");
        mButtonSaveData = findViewById(R.id.button_save_data);
        mButtonClearData = findViewById(R.id.button_clear_data);
        mButtonDisplayData = findViewById(R.id.button_display_data);
    }

    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private void saveDataSharedPref() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(SP_FIRST_NAME, spFirstName);
        editor.putString(SP_LAST_NAME, spLastName);
        editor.putString(SP_EMAIL, spEmail);
        editor.putString(SP_PASSWORD, spPassword);
        editor.putBoolean(SP_TERMS, spTerms);

        editor.apply();
    }

    private void loadDataSharedPref() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        spFirstName = sharedPreferences.getString(SP_FIRST_NAME, "");
        spLastName = sharedPreferences.getString(SP_LAST_NAME, "");
        spEmail = sharedPreferences.getString(SP_EMAIL, "");
        spPassword = sharedPreferences.getString(SP_PASSWORD, "");
        spTerms = sharedPreferences.getBoolean(SP_TERMS, false);
    }

    private void clearDataSharefPref() {

        spFirstName = "";
        spLastName = "";
        spEmail = "";
        spPassword = "";
        spTerms = false;

        saveDataSharedPref();
    }

    private void displayDataSharePref() {

        loadDataSharedPref();

        if (spFirstName.equals("")
                &&spLastName.equals("")
                &&spEmail.equals("")
                &&spPassword.equals("")
                &&!spTerms) {
            mTextViewDisplayData.setText(getString(R.string.empty));
        } else {
            String data = "Data from Shared Preferences" +
                    "\n\nFirst name: "  + spFirstName +
                    "\nLast name: " + spLastName +
                    "\nEmail: " + spEmail +
                    "\nPassword: " + spPassword +
                    "\nTerms and Conditions: " + spTerms;
            mTextViewDisplayData.setText(data);
        }
    }
}
