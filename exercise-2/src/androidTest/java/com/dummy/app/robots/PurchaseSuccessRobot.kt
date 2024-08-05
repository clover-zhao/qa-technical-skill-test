package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class CompletePurchaseRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun checkPurchaseSuccess() {
        assertText("Thank you for your order!")
    }

    fun backToHome() {
        clickTextButton("Back to Home")
        waitForScreen(ScreenNames.PRODUCTS_SCREEN hasText(ScreenTitles.PRODUCTS_SCREEN_TITLE))
    }
}
