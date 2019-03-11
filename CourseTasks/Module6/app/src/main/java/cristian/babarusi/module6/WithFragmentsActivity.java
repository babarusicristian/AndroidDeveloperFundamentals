package cristian.babarusi.module6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class WithFragmentsActivity extends AppCompatActivity {

    private TextView mTextViewFragmentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragments);

        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onCreate - activity", Toast.LENGTH_SHORT).show();
        }

        initView();

        addFragment(R.id.frame_fragment, MyFragment.class);

        //receive data from another activities
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Bundle extrasChallenge34 = getIntent().getExtras();
            if (extrasChallenge34 != null) {
                mTextViewFragmentTitle.setText(extrasChallenge34.getString(MainActivity.KEY_INTENT_DATA));
            }
        } else if (MyFragment.getInstance().getBehavior().equals("custom")) {
            Bundle extrasMain = getIntent().getExtras();
            if (extrasMain != null) {
                String str = extrasMain.getString(MainActivity.DATA_FOR_ACTIVITY);
                mTextViewFragmentTitle.setText(str);
            }
        }
    }

    private void initView() {
        mTextViewFragmentTitle = findViewById(R.id.text_view_fragment_title);
    }

    //pentru a ADAUGA un fragment intr-un anumit layout
    // pe care il ai in activitatea in care vrei sa vezi fragmentul
    private void addFragment(int myLayoutContainer, Class myClass)
    {
        try
        {
            Object myObj = myClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left);
            fragmentTransaction.add(myLayoutContainer, (Fragment) myObj);
            fragmentTransaction.commit(); //abia acum adauga fragmentul

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onStart - activity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onResume - activity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onPause - activity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onRestart - activity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onStop - activity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(WithFragmentsActivity.this, "onDestroy - activity", Toast.LENGTH_SHORT).show();
        }
    }
}
