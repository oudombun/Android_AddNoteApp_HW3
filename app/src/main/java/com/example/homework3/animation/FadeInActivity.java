package com.example.homework3.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework3.MainActivity;
import com.example.homework3.R;

public class FadeInActivity extends AppCompatActivity {
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_in);
        ImageView img1,img2,img3,img4;

        img1= findViewById(R.id.fi_pic1);
        img2= findViewById(R.id.fi_pic2);
        img3= findViewById(R.id.fi_pic3);
        img4= findViewById(R.id.fi_pic4);
        TextView object = findViewById(R.id.txtFadeIn);


        animation = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        img1.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,R.anim.fade_in_2);
        img2.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,R.anim.fade_in_3);
        img3.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,R.anim.fade_in_3);
        img4.startAnimation(animation);

    }

    public void gotoMain(View view) {
        Intent i =new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
