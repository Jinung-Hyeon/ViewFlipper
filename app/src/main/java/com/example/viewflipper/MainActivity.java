package com.example.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button start_btn, stop_btn, previous_btn, next_btn;
    ViewFlipper viewFlipper;
    List<Integer> imageList;
    LayoutInflater layoutInflater;
    View view;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_btn = findViewById(R.id.btn_start);
        stop_btn = findViewById(R.id.btn_stop);
        previous_btn = findViewById(R.id.btn_previous);
        next_btn = findViewById(R.id.btn_next);
        viewFlipper = findViewById(R.id.viewFlipper);
        imageList = new ArrayList<>();
        imageList.add(R.drawable.a);
        imageList.add(R.drawable.b);
        imageList.add(R.drawable.c);

        layoutInflater = LayoutInflater.from(this);
        viewFlipper.setInAnimation(new Animation() {
            @Override
            public void start() {
                super.start();
            }
        });
        //Toast.makeText(MainActivity.this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
        // 애니메이션 리스너
        viewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Toast.makeText(MainActivity.this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
                //Log.d("msgmsg", "onAnimationStart: "+ viewFlipper.getDisplayedChild());
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //Toast.makeText(MainActivity.this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
                Log.d("msgmsg", "onAnimationStart: "+ viewFlipper.getDisplayedChild());
                if (imageList.size() - 1 == viewFlipper.getDisplayedChild()) {
                    viewFlipper.stopFlipping();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        for (int i = 0; i < imageList.size(); i++) {
            view = layoutInflater.inflate(R.layout.image_layout, null, false);
            iv = view.findViewById(R.id.iv);
            iv.setImageResource(imageList.get(i));
            viewFlipper.addView(view);
        }

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.startFlipping();
                viewFlipper.setFlipInterval(2000);

            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
            }
        });

        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
                Toast.makeText(MainActivity.this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });
//        viewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                Toast.makeText(MainActivity.this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                //Toast.makeText(this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

        //Toast.makeText(this, viewFlipper.getDisplayedChild()+"", Toast.LENGTH_SHORT).show();
    }

}