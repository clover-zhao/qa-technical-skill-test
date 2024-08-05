package com.dummy.app.base

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.dummy.app.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
abstract class BaseTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
}
