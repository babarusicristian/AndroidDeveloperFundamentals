package cristian.babarusi.module7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class Challenge6Activity extends AppCompatActivity {

    public static final int CAMERA = 101;
    public static final int GALLERY = 202;
    private static final int CAM_PERMISION_CODE = 200;

    private Button mButtonTakePicture; //for camera button
    private Button mButtonGallery; //to open gallery
    private ImageView mImageViewDisplayPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge6);

        initView();

        mButtonTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Challenge6Activity.this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {
                    //open camera
                    Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (intentTakePicture.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intentTakePicture, CAMERA);
                    }
                } else {
                    //open specific fragment to ask for permission
                    ActivityCompat.requestPermissions(Challenge6Activity.this, new String[] {Manifest.permission.CAMERA}, CAM_PERMISION_CODE);
                }
            }
        });

        mButtonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open gallery
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, GALLERY);
            }
        });
    }

    private void initView() {
        mButtonTakePicture = findViewById(R.id.button_take_picture);
        mImageViewDisplayPicture = findViewById(R.id.image_view_display_picture);
        mButtonGallery = findViewById(R.id.button_gallery);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            return;
        }

        //for camera
        if (requestCode == CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageViewDisplayPicture.setImageBitmap(imageBitmap);
            return;
        }

        //for gallery
        if (requestCode == GALLERY && resultCode == RESULT_OK) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    mImageViewDisplayPicture.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(Challenge6Activity.this, "Failed! to load image", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
