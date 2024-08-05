package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class CartRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun startPurchase() {
        clickTextButton("Checkout")
        waitForScreen(ScreenNames.INFORMATION_SCREEN, hasText(ScreenTitles.INFORMATION_SCREEN_TITLE))
    }

    fun getCartItemCount(): Int {
        return composeRule.onAllNodes(hasContentDescription("Item Image")).size
    }

    fun assertCartItemCount(expectedCount: Int) {
        return getCartItemCount().let {
            if (it != expectedCount) {
                throw AssertionError("Expected cart item count: $expectedCount, but found: $it")
            }
        }  
    }
}
