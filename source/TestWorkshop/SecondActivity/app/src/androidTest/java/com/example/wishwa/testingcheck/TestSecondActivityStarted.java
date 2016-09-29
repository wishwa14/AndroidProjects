package com.example.wishwa.testingcheck;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Wishwa on 21/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class TestSecondActivityStarted{

    @Rule
    public IntentsTestRule<MainActivity> mActivityTestRule = new IntentsTestRule<MainActivity>(MainActivity.class);

    @Test
    public void validateSecondActivity() {

        onView(withId(R.id.button)).perform(click());
        /*onView(withId(R.id.textView2))
                .check(matches(withText(("Wishwa"))));*/
        /*onView(withId(R.id.activity_main)).check(matches(not(isDisplayed())));*/

    }
    @Test
    public void navigate() {


        onView(withText("Click Me")).perform(click());
        Activity activity = getActivityInstance();
        boolean b = (activity instanceof Display);
        assertTrue(b);

    }

    public Activity getActivityInstance() {
        final Activity[] activity = new Activity[1];
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable( ) {
            public void run() {
                Activity currentActivity = null;
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()){
                    currentActivity = (Activity) resumedActivities.iterator().next();
                    activity[0] = currentActivity;
                }
            }
        });
        return activity[0];
    }

}
