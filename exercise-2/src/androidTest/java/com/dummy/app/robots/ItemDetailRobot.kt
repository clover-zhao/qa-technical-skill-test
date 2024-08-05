package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class ItemDetailRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun addToCart() {
        clickTextButton("Add to Cart")
    }

    fun checkItemAdded() {
        assertText("Remove")
    }

    fun backToProducts() {
        clickTextButton("Back to Products")
        waitForScreen(ScreenNames.Products_SCREEN, hasText(ScreenTitles.Products_SCREEN))
    }
}
