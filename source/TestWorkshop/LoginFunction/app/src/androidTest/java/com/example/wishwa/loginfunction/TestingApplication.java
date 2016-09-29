package com.example.wishwa.loginfunction;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.view.inputmethod.InputMethodManager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Wishwa on 21/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class TestingApplication {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void bothUsernameAndPasswordEmpty(){
        onView(withId(R.id.login)).perform(click());
        onView(withText("Username and Password Empty")).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }

    @Test
    public void passwordEmpty(){
        onView(withId(R.id.username)).perform(ViewActions.typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Password is Empty")).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }



    @Test
    public void usernameEmpty(){
        onView(withId(R.id.passwrd)).perform(ViewActions.typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Username is Empty")).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }

    @Test
    public void wrongInputs(){
        onView(withId(R.id.username)).perform(ViewActions.typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.passwrd)).perform(ViewActions.typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Wrong Username or Password")).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }

    @Test
    public void correctInputs(){

        onView(withId(R.id.username)).perform(ViewActions.typeText("Wishwa"),closeSoftKeyboard());
        onView(withId(R.id.passwrd)).perform(ViewActions.typeText("123"),closeSoftKeyboard());
        onView(withText("Login")).perform(click());
        Activity activity = getActivityInstance();
        boolean b = (activity instanceof Display);
        assertTrue(b);
    }

    @Test
    public void checkKeyboard(){

        onView(withId(R.id.username)).perform(click());
        onView(withId(R.id.mainlayout)).perform(clickTopLeft());
        InputMethodManager inputMethodManager = (InputMethodManager)mActivityTestRule.getActivity().getSystemService(INPUT_METHOD_SERVICE);
        boolean keyboardExist = inputMethodManager.isAcceptingText();
        assertTrue(keyboardExist);
    }



    
    @Test
    public void checkSecondActivity(){

        onView(withId(R.id.welcome)).check(matches(isDisplayed()));
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



    public static ViewAction clickTopLeft() {
        return actionWithAssertions(
                new GeneralClickAction(Tap.SINGLE, GeneralLocation.TOP_LEFT, Press.FINGER));
    }


}
