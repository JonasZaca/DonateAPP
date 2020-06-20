package com.personal.DonateApp;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestandoApp {

    @Rule
    public ActivityTestRule<Logando> mActivityTestRule = new ActivityTestRule<>(Logando.class);

    @Test
    public void testandoApp() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editUser),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("aluno@gmail.com"), closeSoftKeyboard());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editPass),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("123"), closeSoftKeyboard());

       Thread.sleep(2000);

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.logar), withText("Logar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        Thread.sleep(5000);

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editUser), withText("aluno@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("adm@doacao.com"));

        Thread.sleep(2000);

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editUser), withText("adm@doacao.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editPass), withText("123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("12345"));

        Thread.sleep(2000);

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editPass), withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());

        Thread.sleep(5000);


        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.logar), withText("Logar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton2.perform(click());

        Thread.sleep(5000);

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btChat), withText("Chat"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

        Thread.sleep(4000);

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.edtDescri),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("estou testando o app"), closeSoftKeyboard());

        Thread.sleep(4000);

        ViewInteraction appCompatImageButton = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1),
                        1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        Thread.sleep(4000);

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.edtDescri),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("ok"), closeSoftKeyboard());

        Thread.sleep(4000);

        ViewInteraction appCompatImageButton2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1),
                        1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        Thread.sleep(2000);

        pressBack();

        Thread.sleep(4000);


        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btDoar), withText("Doar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton4.perform(click());

        Thread.sleep(4000);

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText9.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("230"), closeSoftKeyboard());

        Thread.sleep(2000);

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnDoar), withText("Depositar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton5.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText11.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("250"), closeSoftKeyboard());

        Thread.sleep(2000);

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnDoar), withText("Doar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton6.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText13.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("200"), closeSoftKeyboard());

        Thread.sleep(2000);

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnDoar), withText("Doar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton7.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText15.perform(click());

        Thread.sleep(2000);

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.edtxtValor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("30"), closeSoftKeyboard());

        Thread.sleep(2000);

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnDoar), withText("Doar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton8.perform(click());

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
