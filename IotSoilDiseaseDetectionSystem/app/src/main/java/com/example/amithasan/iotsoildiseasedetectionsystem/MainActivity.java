package com.example.amithasan.iotsoildiseasedetectionsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar lpgBar;
    private int lpgBarStatus=0;
    private Handler mHandler=new Handler();

    private Button gsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        lpgBar=(ProgressBar)findViewById(R.id.pgBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(lpgBarStatus < 100) {
                    lpgBarStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            lpgBar.setProgress(lpgBarStatus);
                        }
                    });

                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(i);
                    }
                });
            }
        }){

        }.start();

    }
}
