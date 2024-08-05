package com.dummy.app.robots

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.dummy.app.constants.ScreenNames
import com.dummy.app.constants.ScreenTitles

class ProductsRobot(composeRule: ComposeTestRule) : GeneralRobot(composeRule) {
    fun openItem(position: Int) {
        // suppose the item image has a content description of "Item Image"
        composeRule.onAllNodes(hasContentDescription("Item Image"))[position].assertIsDisplayed().performClick()
        waitForScreen("Item Screen", hasText("Item Details"))
    }

    fun addItemToCart(position: Int) {
        composeRule.onAllNodesWithText("Add to Cart")[position].performClick()
    }

    fun getCartItemCount(): Int {
        return composeRule.onAllNodesWithText("Remove").size
    }

    fun assertCartItemCount(expectedCount: Int) {
        return getCartItemCount().let {
            if (it != expectedCount) {
                throw AssertionError("Expected cart item count: $expectedCount, but found: $it")
            }
        }
    }

    fun goToCart() {
        // suppose the cart icon has a content description of "Cart"
        clickIconButton("Cart")
        waitForScreen(ScreenNames.CART_SCREEN, hasText(ScreenTitles.CART_SCREEN_TITLE))
    }
}
