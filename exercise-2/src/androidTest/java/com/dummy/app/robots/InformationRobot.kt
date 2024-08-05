package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class InformationRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun enterFirstName(firstName: String) {
        inputText("First Name", firstName)
    }
    fun enterLastName(lastName: String) {
        inputText("Last Name", lastName)
    }
    fun enterPostalCode(postalCode: String) {
        inputText("Zip/Postal Code", postalCode)
    }
    fun clickContinue() {
        clickTextButton("Continue")
        waitForScreen(ScreenNames.CONFIRM_PURCHASE_SCREEN, hasText(ScreenTitles.CONFIRM_PURCHASE_SCREEN_TITLE))
    }
}
