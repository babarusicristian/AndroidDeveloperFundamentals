package cristian.babarusi.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button mButtonClearRating;
    private Button mButtonAnimateRating;
    private Button mButtonDisplayRating;
    private SeekBar mSeekBar;
    private ProgressBar mProgressBar;
    private Button mButtonStartTask;
    private Button mButtonCancelTask;
    private RatingBar mRatingBar;
    private TextView mTextViewStatusSeekBar;
    private TextView mTextViewStatusProgressBar;
    private Timer mTimerProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        autoLoad();

        mButtonClearRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingBar.setRating(0);
            }
        });

        mButtonAnimateRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Timer timerAnim = new Timer();
                timerAnim.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mRatingBar.setRating(mRatingBar.getRating() + 0.5F);

                        if (mRatingBar.getRating() == 5.0) {
                            timerAnim.cancel();
                        }
                    }
                }, 0, 50);
            }
        });

        mButtonDisplayRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.the_rating_is) + " " + mRatingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextViewStatusSeekBar.setText(MessageFormat.format("{0} {1} / {2}", getString(R.string.volume), progress, seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, getString(R.string.started_tracking), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, getString(R.string.stopped_tracking), Toast.LENGTH_SHORT).show();
            }
        });

        mButtonStartTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //some simulated task on some period of time...
                mButtonCancelTask.setEnabled(true);
                mTimerProgressBar = new Timer();
                mTimerProgressBar.schedule(new TimerTask() {
                    Random random = new Random();
                    int work = 0;

                    @Override
                    public void run() {
                        work += random.nextInt(15);
                        mProgressBar.setProgress(work);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextViewStatusProgressBar.setText(MessageFormat.format("{0}% {1}", mProgressBar.getProgress(), getString(R.string.incomplete)));
                            }
                        });

                        if (work >= 50 && work <= 70) {
                            work += 20;
                            mProgressBar.setProgress(work);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mTextViewStatusProgressBar.setText(MessageFormat.format("{0}% {1}", mProgressBar.getProgress(), getString(R.string.incomplete)));
                                }
                            });
                        }
                        if (work >= 100) {
                            mTimerProgressBar.cancel();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mTextViewStatusProgressBar.setText(MessageFormat.format("{0}% {1}", mProgressBar.getProgress(), getString(R.string.complete)));
                                    mButtonCancelTask.setEnabled(false);
                                }
                            });
                        }
                    }
                }, 0, 400);
            }
        });

        mButtonCancelTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimerProgressBar.cancel();
                mProgressBar.setProgress(0);
                mTextViewStatusProgressBar.setText(MessageFormat.format("0% {0}", getString(R.string.incomplete)));
                mButtonCancelTask.setEnabled(false);
            }
        });
    }

    private void initView() {
        mRatingBar = findViewById(R.id.ratingbar_evaluate);
        mButtonClearRating = findViewById(R.id.button_clear_rating);
        mButtonAnimateRating = findViewById(R.id.button_animate_rating);
        mButtonDisplayRating = findViewById(R.id.button_display_rating);
        mSeekBar = findViewById(R.id.seekbar_volume);
        mTextViewStatusSeekBar = findViewById(R.id.textview_status_seekbar);
        mProgressBar = findViewById(R.id.progressbar_task);
        mButtonStartTask = findViewById(R.id.button_start_task);
        mButtonCancelTask = findViewById(R.id.button_cancel_task);
        mTextViewStatusProgressBar = findViewById(R.id.textview_status_progressbar);
    }

    private void autoLoad() {
        mTextViewStatusSeekBar.setText(MessageFormat.format("{0} 0 / {1}", getString(R.string.volume), mSeekBar.getMax()));
        mTextViewStatusProgressBar.setText(MessageFormat.format(" 0% {0}", getString(R.string.incomplete)));
    }
}
