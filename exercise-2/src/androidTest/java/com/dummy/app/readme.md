## Scenario 1
This project provides an end-to-end (E2E) test framework for an Android application using Jetpack Compose. The framework uses the Robot Pattern to encapsulate interactions with different screens.

## Scenario 2
### 1. When navigating to different screens in Scenario 1:
- **Question**: How do you know the test went to the next screen? What if the network connection is slow?
- **Answer**:
    To ensure that the test has navigated to the next screen, we can use assertions to check for the presence of unique elements on the target screen, such as the screen title.  
    If the network connection is slow, we can implement a wait-until condition to handle delays.
- **Question**: Implement an internal method that handles this
- **Code**:
    ```kotlin
    // src/androidTest/java/com/dummy/app/tests/PurchaseFlowTest.kt
    fun waitFor(matcher: SemanticsMatcher, timeoutMillis: Long = TimeUnit.SECONDS.toMillis(10)) =
        composeRule.waitUntilExactlyOneExists(matcher, timeoutMillis)

    fun waitForScreen(screenName: String, matcher: SemanticsMatcher, timeoutMillis: Long = TimeUnit.SECONDS.toMillis(10)) {
        waitFor(matcher, timeoutMillis)
        Log.d("ScreenTransition", "Current screen: $screenName")
    }
    ```

### 2. When navigating to different screens in Scenario 1:
- **Question**: How do you know the test went to the next screen? What if the network connection is slow?
- **Answer**:
    To ensure that the test has navigated to the next screen, we can use assertions to check for the presence of unique elements on the target screen, such as the screen title. If the network connection is slow, we can implement a wait-until condition to handle delays.

- **Question**:Implement an internal method that handles this.

- **Code**:
    ```kotlin
    // src/androidTest/java/com/dummy/app/tests/PurchaseFlowTest.kt
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
    ```
    ```kotlin
    // src/androidTest/java/com/dummy/app/tests/PurchaseFlowTest.kt
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
    ```

### 3. Following the documentation from Jetpack Compose (or the framework of your choice):
- **Question**: What is required before the test starts?
    - **Answer**: Before the test starts, we need to set up the `ComposeTestRule` and ensure that the app is in the correct initial state, such as navigating to the login screen in this case.
    - **Code**:
        ```kotlin
        @get:Rule
        val composeTestRule = createComposeRule()

        @Before
        fun setUp() {
            // Code to navigate to the initial state (e.g., login screen)
            composeTestRule.setContent {
                MyApp {
                    // Initial state setup
                }
            }
        }
        ```

### 4. Thoughts on the Bonus Point (5a.):
- **Question**: Please briefly explain your thoughts.
    - **Answer**: It is a good practice to ensure that the correct number of items are in the cart before proceeding with the purchase. This adds an extra layer of validation to the test, ensuring that the items were added to the cart correctly. It helps catch any potential issues in the add-to-cart functionality and ensures the integrity of the purchase flow.
