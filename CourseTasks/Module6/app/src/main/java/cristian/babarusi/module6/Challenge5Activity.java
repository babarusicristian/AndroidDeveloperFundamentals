package cristian.babarusi.module6;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cristian.babarusi.module6.TheFragments.InterfaceFragment;
import cristian.babarusi.module6.TheFragments.MyInterfaceFragments;

public class Challenge5Activity extends AppCompatActivity {

    private EditText mEditTextText;
    private Button mButtonSendText;
    private InterfaceFragment interfaceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge5);

        initView();

        //default fragment on activity load...
        interfaceFragment = new InterfaceFragment();
        addFragment(interfaceFragment);

        mButtonSendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO click on button to send the text to the fragment

                if (mEditTextText.getText().toString().isEmpty()) {
                    mEditTextText.setError(getString(R.string.fill_a_text));
                    mEditTextText.requestFocus();
                } else {
                    String theText = mEditTextText.getText().toString();
                    hideKeyboard(v);
                    interfaceFragment.displayText(theText);
                }
            }
        });
    }

    private void initView() {
        mEditTextText = findViewById(R.id.edit_text_text);
        mButtonSendText = findViewById(R.id.button_send_text);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left);
        fragmentTransaction.replace(R.id.container_frame_challenge5, fragment);
        fragmentTransaction.commit();
    }

    private void hideKeyboard(View view) {
        getWindow().getDecorView().findViewById(android.R.id.content);
        InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
