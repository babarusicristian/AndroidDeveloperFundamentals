package cristian.babarusi.module4;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Challenge3Activity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ImageView mImageViewSnowing;
    private Button mButtonGinglesBells;
    private Button mButtonLetIsSnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge3);

        initView();

        mButtonGinglesBells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    Toast.makeText(Challenge3Activity.this,
                            getString(R.string.gingles_bells_allready_playing),
                            Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    Toast.makeText(Challenge3Activity.this,
                            getString(R.string.gingles_bells_started)
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonGinglesBells.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(Challenge3Activity.this,
                            R.raw.gingles_bells_remix);
                    Toast.makeText(Challenge3Activity.this,
                            getString(R.string.gingles_bells_stopped)
                            , Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        mButtonLetIsSnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mImageViewSnowing.setVisibility(View.VISIBLE);
                final Animation animationFadeIn =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.fade_in);
                mImageViewSnowing.startAnimation(animationFadeIn);

                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (animationFadeIn.hasEnded()) {
                                    Toast.makeText(Challenge3Activity.this,
                                            getString(R.string.wow_it_is_snowing)
                                            , Toast.LENGTH_SHORT).show();
                                    timer.cancel();
                                }
                            }
                        });
                    }
                }, 0, 100);
            }
        });

        mButtonLetIsSnow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final Animation animationFadeOut =
                        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                mImageViewSnowing.startAnimation(animationFadeOut);

                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (animationFadeOut.hasEnded()) {
                                    mImageViewSnowing.setVisibility(View.GONE);
                                    Toast.makeText(Challenge3Activity.this,
                                            getString(R.string.ohh_no_snowing_anymore)
                                            , Toast.LENGTH_SHORT).show();
                                    timer.cancel();
                                }
                            }
                        });
                    }
                }, 0, 100);
                return true;
            }
        });
    }

    private void initView() {
        mediaPlayer = MediaPlayer.create(Challenge3Activity.this, R.raw.gingles_bells_remix);
        mImageViewSnowing = findViewById(R.id.imageview_snowing);
        Glide.with(this).load(R.drawable.snowing).into(mImageViewSnowing);
        mButtonGinglesBells = findViewById(R.id.button_gingles_bells);
        mButtonLetIsSnow = findViewById(R.id.button_let_it_snow);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }
}
