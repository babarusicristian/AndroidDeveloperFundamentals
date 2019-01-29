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

    Button btnClearRating;
    Button btnAnimateRating;
    Button btnDisplayRating;
    Button btnQuit;
    SeekBar seekBar;
    ProgressBar progressBar;
    Button btnStartTask;
    Button btnCancelTask;
    RatingBar ratingBar;
    TextView tvStatusSeekBar;
    TextView tvStatusProgressBar;
    Timer timerProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        btnClearRating = findViewById(R.id.btnClearRating);
        btnAnimateRating = findViewById(R.id.btnAnimateRating);
        btnDisplayRating = findViewById(R.id.btnDisplayRating);
        btnQuit = findViewById(R.id.btnQuit);
        seekBar = findViewById(R.id.seekBar);
        tvStatusSeekBar = findViewById(R.id.tvStatusSeekBar);
        progressBar = findViewById(R.id.progressBar);
        btnStartTask = findViewById(R.id.btnStartTask);
        btnCancelTask = findViewById(R.id.btnCancelTask);
        tvStatusProgressBar = findViewById(R.id.tvStatusProgressBar);

        tvStatusSeekBar.setText(MessageFormat.format("{0} 0 / {1}", getString(R.string.volume), seekBar.getMax()));
        tvStatusProgressBar.setText(MessageFormat.format(" 0% {0}", getString(R.string.incomplete)));

        btnClearRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setRating(0);
            }
        });

        btnAnimateRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ratingBar.setRating(ratingBar.getRating() + 0.5F);

                        if (ratingBar.getRating() == 5.0) {
                            timer.cancel();
                        }
                    }
                }, 0, 50);
            }
        });

        btnDisplayRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "The rating is: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvStatusSeekBar.setText(MessageFormat.format("{0} {1} / {2}", getString(R.string.volume), progress, seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Started tracking...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Stopped tracking...", Toast.LENGTH_SHORT).show();
            }
        });

        btnStartTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //some simulated task and time...
                btnCancelTask.setEnabled(true);
                timerProgressBar = new Timer();
                timerProgressBar.schedule(new TimerTask() {
                    Random random = new Random();
                    int work = 0;

                    @Override
                    public void run() {
                        work += random.nextInt(15);
                        progressBar.setProgress(work);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvStatusProgressBar.setText(MessageFormat.format("{0}% {1}", progressBar.getProgress(), getString(R.string.incomplete)));
                            }
                        });

                        if (work >= 50 && work <= 70) {
                            work += 20;
                            progressBar.setProgress(work);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvStatusProgressBar.setText(MessageFormat.format("{0}% {1}", progressBar.getProgress(), getString(R.string.incomplete)));
                                }
                            });
                        }
                        if (work >= 100) {
                            timerProgressBar.cancel();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvStatusProgressBar.setText(MessageFormat.format("{0}% {1}", progressBar.getProgress(), getString(R.string.complete)));
                                    btnCancelTask.setEnabled(false);
                                }
                            });
                        }
                    }
                }, 0, 400);
            }
        });

        btnCancelTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerProgressBar.cancel();
                progressBar.setProgress(0);
                tvStatusProgressBar.setText(MessageFormat.format("0% {0}", getString(R.string.incomplete)));
                btnCancelTask.setEnabled(false);
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }
}
