package com.example.checker;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.checker.R.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        final LottieAnimationView checkMark = findViewById(id.checkMark);
        Button btn_checkLogin = findViewById(id.checkLogin);
        TextView tv_appTitle = findViewById(id.checkLogin);

        btn_checkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        new Handler().postDelayed(new Runnable(){

                            @Override
                            public void run() {
                                checkMark.playAnimation();//0.3초 후 애니메이션 시작
                                new Handler().postDelayed(new Runnable(){
                                public void run(){
                                Intent intent = new Intent(MainActivity.this, schedule_Activity.class);
                                startActivity(intent);//0.8초 후 schedule_Activity로 이동
                            }
                        }, 800);
                            }
                        },300);














            }
        });



    }
}