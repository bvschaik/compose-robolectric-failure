package com.github.bvschaik.composerobolectric

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openCloseBottomSheet() {
        with(composeTestRule) {
            setContent {
                MainScreen()
            }
            // Open bottom sheet
            onNode(hasText("Hit me") and hasClickAction())
                .assertIsDisplayed()
                .performClick()

            val closeButton = onNodeWithContentDescription("Close this")

            // Click the close button in the bottom sheet
            closeButton
                .assertIsDisplayed()
                .assertHasClickAction()
                .performClick()

            // Check bottom sheet is indeed gone: this fails on API 27 and 29+
            closeButton.assertIsNotDisplayed()
        }
    }
}