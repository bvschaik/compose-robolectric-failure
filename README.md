# Reproduction project for Compose vs Robolectric issue

Robolectric issue: https://github.com/robolectric/robolectric/issues/9595

## The app

This is a simple Compose Android app with one button that opens a bottom sheet. In the bottom sheet is a close button to hide the bottom sheet.

## The test

The one unit test (not Android test) does the following:

1. it starts the screen
2. it clicks the button to open the bottom sheet
3. it checks that the bottom sheet is visible
4. it clicks the close button to hide the bottom sheet
5. it checks that the bottom sheet is now gone

## The problem

Running this test with Compose BOM 2024.09.01 with Robolectric 4.13:

- Running on API levels 24, 25, 26, 28: the test succeeds (I didn't test < 24)
- Running on API levels 27, and >=29: the test fails because the onClick handler of the close button inside the bottom sheet is gone

When downgrading Compose BOM to 2024.04.01, all API levels succeed.
