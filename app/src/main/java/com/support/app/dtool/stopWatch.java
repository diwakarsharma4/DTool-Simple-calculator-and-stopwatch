package com.support.app.dtool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class stopWatch extends AppCompatActivity {

    ImageButton  start, pause, lap, reset;
    TextView txtTimer;
    Handler customHandler = new Handler();

    LinearLayout container;

    long startTime = 0L, timeInMl = 0L, timeSwap = 0L, updateTime = 0L;

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMl = SystemClock.uptimeMillis()-startTime;
            updateTime = timeSwap+timeInMl;
            int secs = (int) (updateTime/1000);
            int mins = secs/60;
            secs%=60;
            int millisecs = (int)(updateTime%1000);
            txtTimer.setText(""+mins+":"+String.format(Locale.getDefault(),"%2d",secs)+":"+String.format(Locale.getDefault(),"%3d",millisecs));
            customHandler.postDelayed(this,0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);

        getWindow().setStatusBarColor(ContextCompat.getColor(stopWatch.this,R.color.teal_200));

        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        lap = findViewById(R.id.lap);
        reset = findViewById(R.id.reset);
        txtTimer = (TextView) findViewById(R.id.timervalue);
        container = (LinearLayout) findViewById(R.id.container);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread,0);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSwap+=timeInMl;
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View addView = inflater.inflate(R.layout.row,null);
                TextView txtValue = (TextView) addView.findViewById(R.id.txtContent);
                txtValue.setText(txtTimer.getText());
                container.addView(addView);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTimer.setText("");
            }
        });
    }
}
