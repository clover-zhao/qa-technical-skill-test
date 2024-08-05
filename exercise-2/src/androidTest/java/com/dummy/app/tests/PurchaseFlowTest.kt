package com.dummy.app.tests

import com.dummy.app.base.BaseTest
import com.dummy.app.robots.*
import org.junit.Test

class PurchaseFlowTest : BaseTest() {

    private lateinit var loginRobot: LoginRobot
    private lateinit var showcaseRobot: ShowcaseRobot
    private lateinit var itemRobot: ItemRobot
    private lateinit var cartRobot: CartRobot
    private lateinit var addressRobot: AddressRobot
    private lateinit var confirmPurchaseRobot: ConfirmPurchaseRobot

    @Before
    fun setUp() {
        loginRobot = LoginRobot(composeTestRule)
        showcaseRobot = ShowcaseRobot(composeTestRule)
        itemRobot = ItemRobot(composeTestRule)
        cartRobot = CartRobot(composeTestRule)
        addressRobot = AddressRobot(composeTestRule)
        confirmPurchaseRobot = ConfirmPurchaseRobot(composeTestRule)

        // init the state to login screen
        loginRobot.setUpLoginScreen()
    }

    @Test
    fun testPurchaseFlow() {
        // Step 1: Login
        with(loginRobot) {
            assertText("Login")
            inputUsername("standard_user")
            inputPassword("secret_sauce")
            clickLogin()
            assertText(ScreenTitles.PRODUCTS_SCREEN_TITLE)
        }

        // Step 2: Open first item and add to cart
        with(itemDetailRobot) {
            openItem(0)
            assertText(ScreenTitles.ITEM_DETAIL_SCREEN_TITLE)
            addToCart()
            checkItemAdded()
            backToProducts()
        }

        // Step 3: Add another item to cart and go to cart
        with(productsRobot) {
            assertText(ScreenTitles.PRODUCTS_SCREEN_TITLE)
            assertCartItemCount(1)
            // first item is already added to cart, so seconed item is at position 0
            addItemToCart(0)
            assertCartItemCount(2)
            goToCart()
        }

        // Step 4: Check cart items count and start purchase flow
        with(cartRobot) {
            assertText(ScreenTitles.CART_SCREEN_TITLE)
            assertCartItemCount(2)
            startPurchase()
        }

        // Step 5: input address
        with(informationRobot) {
            assertText(ScreenTitles.INFORMATION_SCREEN_TITLE)
            enterFirstName("John")
            enterLastName("Doe")
            enterPostalCode("12345")
            clickContinue()
        }

        // Step 6: Confirm purchase
        with(confirmPurchaseRobot) {
            assertText(ScreenTitles.CONFIRM_PURCHASE_SCREEN_TITLE)
            finishPurchase()
        }
        
        // Step 7: verify purchase success
        with(CompletePurchaseRobot) {
            assertText(ScreenTitles.PURCHASE_SUCCESS_TITLE)
            checkPurchaseSuccess()
            backToHome()
            assertText(ScreenTitles.PRODUCTS_SCREEN_TITLE)
        }
    }
}
