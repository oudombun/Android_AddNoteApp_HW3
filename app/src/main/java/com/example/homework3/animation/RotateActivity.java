package com.example.homework3.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework3.MainActivity;
import com.example.homework3.R;

public class RotateActivity extends AppCompatActivity {
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        TextView object = findViewById(R.id.txtRotate);

        ImageView img1,img2,img3,img4;

        img1= findViewById(R.id.fi_pic1);
        img2= findViewById(R.id.fi_pic2);
        img3= findViewById(R.id.fi_pic3);
        img4= findViewById(R.id.fi_pic4);


        animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        img1.setAnimation(animation);
        img2.setAnimation(animation);
        img3.setAnimation(animation);
        img4.setAnimation(animation);


    }

    public void gotoMain(View view) {
        Intent i =new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
