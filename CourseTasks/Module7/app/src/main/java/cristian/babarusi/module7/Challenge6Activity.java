package cristian.babarusi.module7;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Challenge6Activity extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 101;

    private Button mButtonTakePicture;
    private ImageView mImageViewDisplayPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge6);

        initView();

        mButtonTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intentTakePicture.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intentTakePicture, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    private void initView() {
        mButtonTakePicture = findViewById(R.id.button_take_picture);
        mImageViewDisplayPicture = findViewById(R.id.image_view_display_picture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageViewDisplayPicture.setImageBitmap(imageBitmap);
        }
    }
}
