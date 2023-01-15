package io.github.garykam.atsaplus.ui.spatialrelationship

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Icon(val id: Int, val description: String = "", val size: Dp = 0.dp) {
    val x get() = _x
    val y get() = _y
    val rotation get() = _rotation
    private var _x by mutableStateOf(0.dp)
    private var _y by mutableStateOf(0.dp)
    private var _rotation by mutableStateOf(0F)

    fun relocate(screenWidth: Int, screenHeight: Int) {
        var x = screenWidth * Math.random()
        if (x + size.value >= screenWidth) {
            x -= size.value
        }

        var y = screenHeight * Math.random()
        if (y + size.value >= screenHeight) {
            y -= size.value
        }

        _x = x.dp
        _y = y.dp
        _rotation = (360 * Math.random()).toFloat()
    }
}