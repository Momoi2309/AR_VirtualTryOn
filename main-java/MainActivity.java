package com.unity.mynativeapp;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int BUTTON_RADIUS_DP = 150;
    private static final int BUTTON_COUNT = 6;

    private Button centerButton;
    private List<Button> menuButtons;
    private static int SPLASH_SCREEN = 3000;
    boolean isUnityLoaded = false;
    // Variables for Animation
    Animation topAnim;
    ImageView image;
    TextView   textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the toolbar invisible
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //  Toolbar toolbar = findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);


        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        //Hooks
        image=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView4);

        image.setAnimation(topAnim);
        textView.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

//        handleIntent(getIntent());
    }

}
