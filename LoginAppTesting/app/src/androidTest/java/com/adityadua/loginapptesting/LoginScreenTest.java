package com.adityadua.loginapptesting;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.R.attr.password;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.adityadua.loginapptesting.R.id.userNameEditText;
import static org.junit.Assert.*;

/**
 * Created by AdityaDua on 01/07/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void clickLoginButton(){
        String userName = "aditya";
        String pass ="aditya";

        onView(withId(userNameEditText)).perform(typeText(userName));
        closeSoftKeyboard();

        onView(withId(R.id.passwordET)).perform(typeText(pass));
        closeSoftKeyboard();

        onView(withId(R.id.loginButton)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //onView(withText("Button Clicked")).check(match("Button Clicked"))



    }

}