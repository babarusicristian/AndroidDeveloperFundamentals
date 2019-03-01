package cristian.babarusi.module5;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Pattern;

public class Challenge5Activity extends AppCompatActivity {

    private EditText mEditTextUrl;
    private EditText mEditTextLocation;
    private EditText mEditTextTextToBeShared;

    private Button mButtonOpenWebsite;
    private Button mButtonOpenLocation;
    private Button mButtonShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge5);

        initView();

        mButtonOpenWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textURL = mEditTextUrl.getText().toString();

                if (textURL.isEmpty()) {
                    mEditTextUrl.requestFocus();
                    mEditTextUrl.setError(getString(R.string.provide_url));
                } else if (validUrl(textURL)) {
                    if (!textURL.startsWith("http://")) {
                        String temp = textURL;
                        textURL = "http://" + temp;
                    }
                    //open intent
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(textURL));
                    startActivity(intent);
                } else {
                    mEditTextUrl.requestFocus();
                    mEditTextUrl.setError(getString(R.string.invalid_url));
                }
            }
        });

        mButtonOpenLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextLocation.getText().toString().isEmpty()) {
                    mEditTextLocation.setError(getString(R.string.provide_location));
                    mEditTextLocation.requestFocus();
                } else {
                    openLocation(mEditTextLocation.getText().toString());
                }
            }
        });

        mButtonShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditTextTextToBeShared.getText().toString();
                if (!text.isEmpty()) {
                    shareText(text);
                } else {
                    mEditTextTextToBeShared.setError(getString(R.string.provide_text));
                    mEditTextTextToBeShared.requestFocus();
                }
            }
        });
    }

    private void initView() {
        mEditTextUrl = findViewById(R.id.edittext_url);
        mEditTextLocation = findViewById(R.id.edittext_location);
        mEditTextTextToBeShared = findViewById(R.id.edittext_text_to_share);
        mButtonOpenWebsite = findViewById(R.id.button_open_website);
        mButtonOpenLocation = findViewById(R.id.button_open_location);
        mButtonShareText = findViewById(R.id.button_share_text);
    }

    private boolean validUrl(String url) {
        Pattern pattern = Patterns.WEB_URL;
        return pattern.matcher(url).matches();
    }

    private void openLocation(String loc) {
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intentGeo = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intentGeo.resolveActivity(getPackageManager()) != null) {
            startActivity(intentGeo);
        } else {
            Toast.makeText(Challenge5Activity.this, getString(R.string.you_dont_have_any_app),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void shareText(String text) {
        String signature = "Shared from Module 5 - My Android Course";
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.putExtra(Intent.EXTRA_TEXT, text + "\n\n" + signature);
        intentShare.setType("text/plain");
        startActivity(intentShare);
    }
}
