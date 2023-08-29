package com.unity.mynativeapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.company.product.OverrideUnityActivity;

public class MainUnityActivity extends OverrideUnityActivity {
    // Setup activity layout
    public Button showMainButton;
    public Button unloadButton;
    public Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addControlsToUnityFrame();
        Intent intent = getIntent();
        handleIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        setIntent(intent);
    }

    void handleIntent(Intent intent) {
        if(intent == null || intent.getExtras() == null) return;

        if(intent.getExtras().containsKey("doQuit"))
            if(mUnityPlayer != null) {
                finish();
            }
    }

    @Override
    protected void showMainActivity(String setToColor) {
        Intent intent = new Intent(this, Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("setColor", setToColor);
        startActivity(intent);
    }

    @Override public void onUnityPlayerUnloaded() {
        showMainActivity("");
    }


    public void addControlsToUnityFrame() {
        FrameLayout layout = mUnityPlayer;

        // Create the layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
        layoutParams.setMargins(30, 10, 20, 10);

        // Create and configure the buttons
        Button showMainButton = new Button(this);
        showMainButton.setText("Main");
        showMainButton.setAllCaps(false);
        showMainButton.setTextColor(Color.WHITE);
        showMainButton.setBackgroundColor(Color.BLACK);
        showMainButton.setTypeface(null, Typeface.BOLD); // Set the text to bold

        // Create a drawable with rounded corners
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10); // Set the radius for the corners

        // Set the drawable as the background of the button
        showMainButton.setBackground(gradientDrawable);
        showMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showMainActivity("");
            }
        });
        showMainButton.setLayoutParams(layoutParams);
        Button unloadButton = new Button(this);
        unloadButton.setText("Unload");
        unloadButton.setAllCaps(false);
        unloadButton.setTextColor(Color.WHITE);
        unloadButton.setBackgroundColor(Color.BLACK);
        unloadButton.setTypeface(null, Typeface.BOLD); // Set the text to bold

        // Create a drawable with rounded corners
        GradientDrawable gradient1Drawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10); // Set the radius for the corners

        // Set the drawable as the background of the button
        unloadButton.setBackground(gradient1Drawable);

        unloadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mUnityPlayer.unload();
            }
        });
        unloadButton.setLayoutParams(layoutParams);

        Button finishButton = new Button(this);
        finishButton.setText("Finish");
        finishButton.setAllCaps(false);
        finishButton.setTextColor(Color.WHITE);
        finishButton.setBackgroundColor(Color.BLACK);
        finishButton.setTypeface(null, Typeface.BOLD); // Set the text to bold

        // Create a drawable with rounded corners
        GradientDrawable gradient2Drawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10); // Set the radius for the corners

        // Set the drawable as the background of the button
        finishButton.setBackground(gradient2Drawable);

        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        finishButton.setLayoutParams(layoutParams);

        // Add the buttons to the layout
        LinearLayout topRowLayout = new LinearLayout(this);
        topRowLayout.setOrientation(LinearLayout.HORIZONTAL);
        topRowLayout.addView(showMainButton);
        topRowLayout.addView(finishButton);
        topRowLayout.addView(unloadButton);

        layout.addView(topRowLayout);

        // Add the finish button below the top row
        //        layout.addView(finishButton);
    }


}
