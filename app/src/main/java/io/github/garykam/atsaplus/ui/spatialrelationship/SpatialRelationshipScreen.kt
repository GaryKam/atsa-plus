package io.github.garykam.atsaplus.ui.spatialrelationship

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.garykam.atsaplus.R

@Composable
fun SpatialRelationshipScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Eye()
        Airplane(size = 90.dp)
        Airplane(size = 200.dp)
    }
}

@Composable
private fun Eye() {
    val rotation = (Math.random() * 360).toFloat()
    Image(
        painter = painterResource(id = R.drawable.eye),
        contentDescription = "eye",
        modifier = Modifier.size(160.dp).rotate(rotation)
    )
}

@Composable
private fun Airplane(size: Dp) {
    val rotation = (Math.random() * 360).toFloat()
    Image(
        painter = painterResource(id = R.drawable.airplane),
        contentDescription = "airplane",
        modifier = Modifier.size(size).rotate(rotation)
    )
}