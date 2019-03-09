package com.w.welcomepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("check", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        final Intent welIntent = new Intent(this, Welcome1Activity.class);
        final Intent homeIntent = new Intent(this, HomeActivity.class);
        Timer timer = new Timer();
        firstLoadJudge(timer, welIntent, homeIntent);



    }

    public void firstLoadJudge(Timer timer, final Intent welcome, final Intent home) {
        boolean fristload = sharedPreferences.getBoolean("fristload", true);//从SharedPreferences中获取是否第一次启动   默认为true
        if (fristload) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    startActivity(welcome); //执行进入
                }
            };
            timer.schedule(task, 1000 * 1);
            editor.putBoolean("fristload", false);
            editor.commit();

        } else {
	        Toast.makeText(MainActivity.this, "即将进入home界面", Toast.LENGTH_SHORT).show();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    startActivity(home);
//                    startActivity(welcome);//调试的时候用
                }
            };
            timer.schedule(task, 1000 * 1);
        }
    }

}

