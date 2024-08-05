package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class ConfirmPurchaseRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun finishPurchase() {
        clickTextButton("Finish")
        waitForScreen(ScreenNames.PURCHASE_SUCCESS_SCREEN, hasText(ScreenTitles.PURCHASE_SUCCESS_SCREEN_TITLE))
    }
}
