package com.example.qube.project2simpleshop;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import com.example.qube.project2simpleshop.main.MainActivity;
import com.example.qube.project2simpleshop.setup.CharacterEsper;
import com.example.qube.project2simpleshop.setup.DatabaseHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Qube on 8/21/16.
 */

@RunWith(AndroidJUnit4.class)
public class AppTest {
    private ArrayList<CharacterEsper> list;
    DatabaseHelper db;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    //tests my media player easter egg
    @Test
    public void testIfEasterEggWorks() throws Exception {
        for (int i = 0; i < 8; i++) {
            if (i < 8) {
                onView(withId(R.id.iv_chocobo_caller)).perform(click());
            }
        }
    }

    //test will search for an item display the detail cancel and click it again to add to cart and checkout
    @Test
    public void testSearch() throws Exception {
        onView(withId(R.id.searchOption)).perform(click());
        //No withId for edittext on search option so you use isAssignableFrom and give it the edittext class so you can type your search
        onView(isAssignableFrom(EditText.class)).perform(typeText("Zidane"), pressImeActionButton());
        onView(withId(R.id.rv_search)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.button_cancel_dialog)).perform(click());
        onView(withId(R.id.rv_search)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.button_detail_add_to_cart)).perform(click());
        onView(withId(R.id.cv_button_shopping_cart)).perform(click());
        onView(withId(R.id.cv_checkout)).perform(click());
    }

    //test will add items to cart and then checkout
    @Test
    public void testIfAddAndCheckoutCart() throws Exception {
        CreateList();
        //Used a for loop so when testing it'll go click every position in increments of 5 and add them to cart
        for (int i = 1; i < list.size(); i += 5) {
            onView(withId(R.id.rv_main)).perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
            onView(withId(R.id.button_detail_add_to_cart)).perform(click());
        }
        onView(withId(R.id.cv_button_shopping_cart)).perform(click());
        onView(withId(R.id.cv_checkout)).perform(click());
    }

    //test will check if each item in the list is clickable
    @Test
    public void testIfItemClickable() throws Exception {
        CreateList();
        //Used a for loop so when testing it'll click through each position instead of coding it all out
        for (int i = 0; i < list.size(); i++) {
            onView(withId(R.id.rv_main)).perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
            onView(withId(R.id.button_cancel_dialog)).perform(click());
        }
    }

    //Since I'll use this in multiple test I thought lets just make a method to create the list
    public List<CharacterEsper> CreateList() {
        db = DatabaseHelper.getInstance(InstrumentationRegistry.getTargetContext());
        list = db.getCharactersAndEspers();

        return list;
    }
}
