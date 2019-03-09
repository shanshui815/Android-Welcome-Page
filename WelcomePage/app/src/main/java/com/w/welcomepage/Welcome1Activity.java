package com.w.welcomepage;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        //延迟跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        getApplicationContext(),Welcome2Activity.class
                );
                startActivity(intent);
                overridePendingTransition(R.anim.enter,R.anim.out);

            }
        },4000);

    }
}
