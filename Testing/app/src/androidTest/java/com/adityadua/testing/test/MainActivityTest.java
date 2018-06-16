package com.adityadua.testing.test;

import com.adityadua.testing.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by AdityaDua on 10/06/18.
 */
public class MainActivityTest {


    private String mStringToBetyped;

    @Rule
    public MainActivityTest mActivityRule = new MainActivityTest<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Login";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.

        onView(withHint("ENter UserName")).perform(typeText("aditya.dua"),closeSoftKeyboard());

        onView(withInputType("Password")).perform(typeText("Aditya.Dua"),closeSoftKeyboard());

        onView(withId(R.id.changeTextBtn)).perform(click());




        onView(withId(R.id.editTextUserInput))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(mStringToBetyped)));
    }


}