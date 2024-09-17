package com.github.bvschaik.composerobolectric.ui.theme

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Context.CloseIcon: ImageVector
    get() = ImageVector.Builder(
        name = "CloseIcon",
        defaultWidth = 24.0.dp,
        defaultHeight = 24.0.dp,
        viewportWidth = 24.0f,
        viewportHeight = 24.0f,
        tintColor = Color.Black
    ).apply {
        // M19 6.41 L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z
        path(fill = SolidColor(Color(getColor(android.R.color.white)))) {
            // M 19 6.41
            moveTo(x = 19.0f, y = 6.41f)
            // L 17.59 5
            lineTo(x = 17.59f, y = 5.0f)
            // L 12 10.59
            lineTo(x = 12.0f, y = 10.59f)
            // L 6.41 5
            lineTo(x = 6.41f, y = 5.0f)
            // L 5 6.41
            lineTo(x = 5.0f, y = 6.41f)
            // L 10.59 12
            lineTo(x = 10.59f, y = 12.0f)
            // L 5 17.59
            lineTo(x = 5.0f, y = 17.59f)
            // L 6.41 19
            lineTo(x = 6.41f, y = 19.0f)
            // L 12 13.41
            lineTo(x = 12.0f, y = 13.41f)
            // L 17.59 19
            lineTo(x = 17.59f, y = 19.0f)
            // L 19 17.59
            lineTo(x = 19.0f, y = 17.59f)
            // L 13.41 12z
            lineTo(x = 13.41f, y = 12.0f)
            close()
        }
    }.build()
