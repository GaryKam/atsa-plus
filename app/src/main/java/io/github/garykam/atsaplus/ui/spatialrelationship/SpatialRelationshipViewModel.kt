package io.github.garykam.atsaplus.ui.spatialrelationship

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.garykam.atsaplus.R
import kotlinx.coroutines.flow.*

private val LARGE_ICON_SIZE = 160.dp
private val SMALL_ICON_SIZE = LARGE_ICON_SIZE / 2

data class GameState(
    val eyeIcon: Icon = Icon(id = R.drawable.eye),
    val smallPlaneIcon: Icon = Icon(id = R.drawable.airplane),
    val largePlaneIcon: Icon = Icon(id = R.drawable.airplane),
)

class SpatialRelationshipViewModel : ViewModel() {
    private var eyeIcon =
        MutableStateFlow(Icon(id = R.drawable.eye, description = "eye", size = LARGE_ICON_SIZE))
    private var smallPlaneIcon =
        MutableStateFlow(
            Icon(id = R.drawable.airplane, description = "airplane", size = SMALL_ICON_SIZE)
        )
    private var largePlaneIcon =
        MutableStateFlow(
            Icon(id = R.drawable.airplane, description = "airplane", size = LARGE_ICON_SIZE)
        )

    val gameState: StateFlow<GameState> =
        combine(
            eyeIcon, smallPlaneIcon, largePlaneIcon
        ) { eyeIcon, smallPlaneIcon, largePlaneIcon ->
            GameState(eyeIcon, smallPlaneIcon, largePlaneIcon)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), GameState())

    fun relocateIcons(screenWidth: Int, screenHeight: Int) {
        eyeIcon.value.relocate(screenWidth, screenHeight)
        smallPlaneIcon.value.relocate(screenWidth, screenHeight)
        largePlaneIcon.value.relocate(screenWidth, screenHeight)
    }
}

