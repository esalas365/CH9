package com.salas.msu.criminalintent

import android.widget.CheckBox
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun checkBoxStateEqualsCrimeSolvedState() {
        scenario.onFragment { fragment ->
            onView(withId(R.id.crime_solved)).check(matches(isChecked()))

            val crimeSolvedStatus = fragment.crimeSolvedStatus
            onView(withId(R.id.crime_solved)).check { view, _ ->
                val checkBoxState = (view as CheckBox).isChecked
                assertEquals(checkBoxState, crimeSolvedStatus)
            }
        }
    }
}

