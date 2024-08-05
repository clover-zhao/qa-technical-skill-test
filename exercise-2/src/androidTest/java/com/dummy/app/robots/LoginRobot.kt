package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class LoginRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun setUpLoginScreen() {
        // Assuming there's a method to navigate to the login screen
        navigateToLoginScreen()
        waitFor("Login")
    }

    fun inputUsername(username: String) {
        performTextInput("Username", username)
    }

    fun inputPassword(password: String) {
        performTextInput("Password", password)
    }

    fun clickLogin() {
        clickTextButton("Login")
        waitForScreen(ScreenNames.Products_SCREEN, hasText(ScreenTitles.Products_SCREEN))
    }
}
