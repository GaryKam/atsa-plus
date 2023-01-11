package io.github.garykam.atsaplus.ui.spatialrelationship

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.garykam.atsaplus.R

@Composable
fun SpatialRelationshipScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Eye(size = 160.dp)
        Airplane(size = 80.dp)
        Airplane(size = 160.dp)
    }
}

@Composable
private fun Eye(size: Dp) {
    val configuration = LocalConfiguration.current
    var x = configuration.screenWidthDp * Math.random()
    if (x + size.value >= configuration.screenWidthDp) {
        x -= size.value
    }
    var y = configuration.screenHeightDp * Math.random()
    if (y + size.value >= configuration.screenHeightDp) {
        y -= size.value
    }
    val rotation = (360 * Math.random()).toFloat()
    Image(
        painter = painterResource(id = R.drawable.eye),
        contentDescription = "eye",
        modifier = Modifier
            .size(size)
            .offset(x.dp, y.dp)
            .rotate(rotation)
    )
}

@Composable
private fun Airplane(size: Dp) {
    val rotation = (Math.random() * 360).toFloat()
    Image(
        painter = painterResource(id = R.drawable.airplane),
        contentDescription = "airplane",
        modifier = Modifier
            .size(size)
            .rotate(rotation)
    )
}