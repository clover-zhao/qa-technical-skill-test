package com.dummy.app.robots

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import android.util.Log

abstract class GeneralRobot(val composeRule: ComposeTestRule) {
    // Assertion of buttons and clicking them
    fun clickTextButton(text: String) = composeRule.onNode(hasTextExactly(text)).performClick()

    fun clickIconButton(description: String) = composeRule.onNode(
        hasContentDescription(description).and(
            hasClickAction()
        )
    ).performClick()

    fun inputText(text: String, inputText: String) = 
        composeRule.noNode(hasTextExactly(text)).assertExists().performTextInput(inputText)

    fun assertIconButton(description: String) =
        composeRule.onNode(hasContentDescription(description).and(hasClickAction())).assertExists()

    fun assertTextButton(text: String) = composeRule.onNode(hasText(text).and(hasClickAction())).assertExists()

    fun assertText(text: String, ignoreCase: Boolean = false, substring: Boolean = false) =
        composeRule.onNode(hasText(text, ignoreCase = ignoreCase, substring = substring)).assertExists()

    fun assertDoesNotExistText(text: String, ignoreCase: Boolean = false, substring: Boolean = false) =
        composeRule.onNode(hasText(text, ignoreCase = ignoreCase, substring = substring)).assertDoesNotExist()

    @OptIn(ExperimentalTestApi::class)
    fun waitFor(matcher: SemanticsMatcher, timeoutMillis: Long = TimeUnit.SECONDS.toMillis(10)) =
        composeRule.waitUntilExactlyOneExists(matcher, timeoutMillis)

    fun waitForScreen(screenName: String, matcher: SemanticsMatcher, timeoutMillis: Long = TimeUnit.SECONDS.toMillis(10)) {
        waitFor(matcher, timeoutMillis)
        Log.d("ScreenTransition", "Current screen: $screenName")
    }
}
