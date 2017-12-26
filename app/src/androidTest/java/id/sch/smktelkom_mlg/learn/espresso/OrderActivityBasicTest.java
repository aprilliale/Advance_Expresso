package id.sch.smktelkom_mlg.learn.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by rongrong on 26/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {
    @Rule
    public ActivityTestRule<OrderActivity> mActivityTestRule = new ActivityTestRule<>(OrderActivity.class);

    @Test
    public void clickDecrementButton_ChangeQuantityAndCost() {
        onView((withId(R.id.quantity_text_view))).check(matches(withText("0")));
        onView((withId(R.id.decrement_button))).perform(click());
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));
    }


}
