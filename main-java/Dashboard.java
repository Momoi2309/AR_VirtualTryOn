package com.unity.mynativeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    boolean isUnityLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handleIntent(getIntent());
    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        setIntent(intent);
    }

    void handleIntent(Intent intent) {
        if(intent == null || intent.getExtras() == null) return;

        if(intent.getExtras().containsKey("setColor")){
            View v = findViewById(R.id.button2);
            switch (intent.getExtras().getString("setColor")) {
                case "yellow": v.setBackgroundColor(Color.YELLOW); break;
                case "red": v.setBackgroundColor(Color.RED); break;
                case "blue": v.setBackgroundColor(Color.BLUE); break;
                default: break;
            }
        }
    }

    public void btnLoadUnity(View v) {
        isUnityLoaded = true;
        Intent intent = new Intent(this, MainUnityActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) isUnityLoaded = false;
    }

    public void unloadUnity(Boolean doShowToast) {
        if(isUnityLoaded) {
            Intent intent = new Intent(this, MainUnityActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.putExtra("doQuit", true);
            startActivity(intent);
            isUnityLoaded = false;
        }
        else if(doShowToast) showToast("Show Unity First");
    }

    public void btnUnloadUnity(View v) {
        unloadUnity(true);
    }

    public void showToast(String message) {
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    //The following code creates an Intent to launch the ARCore Scene Viewer with a 3D modelS
    // The setData() method specifies the URL for the ARCore Scene Viewer, and the buildUpon()
    // method allows you to add additional query parameters. In this case, the file parameter specifies the URL for the 3D model,
    // the mode parameter specifies that AR mode is preferred, and the title parameter sets the title for the viewer.
    //
    //The setPackage() method specifies the package name for the ARCore Scene Viewer app.
    // If the app is not installed on the device, the user will be prompted to install it.
    // Finally, the startActivity() method launches the ARCore Scene Viewer app with the specified intent.
    //

    // GLASSES 1
    public void arCoreButtong1Clicked(View v) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
//                .appendQueryParameter("file", "https://github.com/KhronosGroup/glTF-Sample-Models/raw/master/2.0/Duck/glTF/Duck.gltf")
                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/glasses/Glasses%201.gltf")
//                .appendQueryParameter("mode", "ar_preferred") // with AR in your space view
                .appendQueryParameter("mode","3d")
                .appendQueryParameter("title", "Glasses #1")
                .build());
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }

    // GLASSES 2
    public void arCoreButtong2Clicked(View v) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/glasses/Glasses%202.gltf")
//                .appendQueryParameter("mode", "ar_preferred") // with AR in your space view
                .appendQueryParameter("mode","3d")
                .appendQueryParameter("title", "Glasses #2")
                .build());
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
  // GLASSES 3
    public void arCoreButtong3Clicked(View v) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/glasses/Glasses%203.gltf")
//                .appendQueryParameter("mode", "ar_preferred") // with AR in your space view
                .appendQueryParameter("mode","3d")
                .appendQueryParameter("title", "Glasses #3")
                .build());
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }

 // WATCH 1
    public void arCoreButtonw1Clicked(View v) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/watches/Watch%201.gltf")
//                .appendQueryParameter("mode", "ar_preferred") // with AR in your space view
                .appendQueryParameter("mode","3d")
                .appendQueryParameter("title", "Watch #1")
                .build());
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
    // WATCH 2
    public void arCoreButtonw2Clicked(View v) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()

                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/watches/Watch%202.gltf")
//                .appendQueryParameter("mode", "ar_preferred") // with AR in your space view
                .appendQueryParameter("mode","3d")
                .appendQueryParameter("title", "Watch #2")
                .build());
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }

    // WATCH 3
    public void arCoreButtonw3Clicked(View v) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/watches/Watch%203.gltf")
//                .appendQueryParameter("mode", "ar_preferred") // with AR in your space view
                .appendQueryParameter("mode","3d")
                .appendQueryParameter("title", "Watch #3")
                .build());
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }


}