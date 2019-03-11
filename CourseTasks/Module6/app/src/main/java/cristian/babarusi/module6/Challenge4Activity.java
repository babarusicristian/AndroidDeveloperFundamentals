package cristian.babarusi.module6;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import cristian.babarusi.module6.TheFragments.MethodsFragment;

public class Challenge4Activity extends AppCompatActivity {

    private EditText mEditTextNumA;
    private EditText mEditTextNumB;
    private Button mButtonSendAddiction;
    private Button mButtonSendSubstraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge4);

        initView();

        final MethodsFragment methodsFragment = new MethodsFragment();
        addFragment(methodsFragment);

        mButtonSendAddiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextNumA.getText().toString().isEmpty()) {
                    mEditTextNumA.setError(getString(R.string.fill_a_number));
                    mEditTextNumA.requestFocus();
                } else if (mEditTextNumB.getText().toString().isEmpty()) {
                    mEditTextNumB.setError(getString(R.string.fill_a_number));
                    mEditTextNumB.requestFocus();
                } else {
                    int numA = Integer.valueOf(mEditTextNumA.getText().toString());
                    int numB = Integer.valueOf(mEditTextNumB.getText().toString());
                    hideKeyboard(v);
                    methodsFragment.displayAddiction(numA, numB);
                }
            }
        });

        mButtonSendSubstraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextNumA.getText().toString().isEmpty()) {
                    mEditTextNumA.setError(getString(R.string.fill_a_number));
                    mEditTextNumA.requestFocus();
                } else if (mEditTextNumB.getText().toString().isEmpty()) {
                    mEditTextNumB.setError(getString(R.string.fill_a_number));
                    mEditTextNumB.requestFocus();
                } else {
                    int numA = Integer.valueOf(mEditTextNumA.getText().toString());
                    int numB = Integer.valueOf(mEditTextNumB.getText().toString());
                    hideKeyboard(v);
                    methodsFragment.displaySubstraction(numA, numB);
                }
            }
        });
    }

    private void initView() {
        mEditTextNumA = findViewById(R.id.edit_text_num_a);
        mEditTextNumB = findViewById(R.id.edit_text_num_b);
        mButtonSendAddiction = findViewById(R.id.button_send_addiction);
        mButtonSendSubstraction = findViewById(R.id.button_send_substraction);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left);
        fragmentTransaction.replace(R.id.container_code_challenge4, fragment);
        fragmentTransaction.commit();
    }

    private void hideKeyboard(View view) {
        getWindow().getDecorView().findViewById(android.R.id.content);
        InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
