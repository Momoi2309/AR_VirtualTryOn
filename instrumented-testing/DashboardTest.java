package com.unity.mynativeapp_test;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import org.junit.runners.MethodSorters;
import android.content.Intent;
import android.net.Uri;

import com.unity.mynativeapp.Dashboard;
import com.unity.mynativeapp.MainUnityActivity;
import com.unity.mynativeapp.R;


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DashboardTest {

    @Rule
    public ActivityTestRule<Dashboard> activityTestRule = new ActivityTestRule<>(Dashboard.class);

    private Dashboard dashboardActivity;

    @Before
    public void setUp() {
        dashboardActivity = activityTestRule.getActivity();
        Intents.init(); // Initialize Intents library
    }

    @After
    public void tearDown() {
        dashboardActivity = null;
        Intents.release(); // Release Intents resources
    }

    @Test
    public void test1MatchedTextView() {
        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("ChronoVision")));
        onView(withId(R.id.textView2)).check(matches(withText("AR Glasses and Watches")));
        onView(withId(R.id.textView3)).check(matches(withText("See how you look with \ndifferent watches and glasses")));
        onView(withId(R.id.textView5)).check(matches(withText("\nSee the rendered 3D models in your \nspace!")));
    }

    @Test // for GLASSES 2
    public void test2ArCoreButtonGlasses2Clicked() {
        onView(withId(R.id.arcore_button2)).perform(click());
        intended(allOf(
                        hasAction(Intent.ACTION_VIEW),
                        hasData(Uri.parse("https://arvr.google.com/scene-viewer/1.0")
                                .buildUpon()
                                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/glasses/Glasses%202.gltf")
                                .appendQueryParameter("mode", "3d")
                                .appendQueryParameter("title", "Glasses #2")
                                .build())
                )
        );
    }

    @Test
    // WATCH 3
    public void test3ArCoreButtonWatches3Clicked() {
        onView(withId(R.id.arcore_button6)).perform(click());
        intended(allOf(
                        hasAction(Intent.ACTION_VIEW),
                        hasData(Uri.parse("https://arvr.google.com/scene-viewer/1.0")
                                .buildUpon()
                                .appendQueryParameter("file", "https://raw.githubusercontent.com/Momoi2309/3dmodels/main/watches/Watch%203.gltf")
                                .appendQueryParameter("mode", "3d")
                                .appendQueryParameter("title", "Watch #3")
                                .build())
                )
        );
    }

    @Test
    public void test4BtnLoadUnityAndExit() {
        onView(withId(R.id.btnloadunity)).perform(click());

        intended(hasComponent(MainUnityActivity.class.getName()));
    }

}




