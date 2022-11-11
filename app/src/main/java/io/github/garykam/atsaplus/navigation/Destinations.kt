package io.github.garykam.atsaplus.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val icon: ImageVector
    val route: String
}

object Home : Destination {
    override val icon: ImageVector = Icons.Filled.Home
    override val route: String = "home"
}

object MemoryDifference : Destination {
    override val icon: ImageVector = Icons.Filled.Delete
    override val route: String = "memory_difference"
}

object MemoryVariable : Destination {
    override val icon: ImageVector = Icons.Filled.Star
    override val route: String = "memory_variable"
}