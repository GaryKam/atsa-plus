package io.github.garykam.atsaplus.ui.spatialrelationship

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SpatialRelationshipScreen(viewModel: SpatialRelationshipViewModel = viewModel()) {
    val gameState by viewModel.gameState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Box(modifier = Modifier.weight(1F)) {
            SpatialImage(icon = gameState.eyeIcon)
            SpatialImage(icon = gameState.smallPlaneIcon)
            SpatialImage(icon = gameState.largePlaneIcon)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1F),
            horizontalArrangement = Arrangement.Center
        ) {
            val configuration = LocalConfiguration.current

            Button(onClick = {
                viewModel.relocateIcons(
                    screenWidth = configuration.screenWidthDp,
                    screenHeight = configuration.screenHeightDp
                )
            }) {
                Text(text = "Relocate")
            }
        }
    }
}

@Composable
private fun SpatialImage(icon: Icon) {
    Image(
        painter = painterResource(id = icon.id),
        contentDescription = icon.description,
        modifier = Modifier
            .size(icon.size)
            .offset(icon.x, icon.y)
            .rotate(icon.rotation)
    )
}