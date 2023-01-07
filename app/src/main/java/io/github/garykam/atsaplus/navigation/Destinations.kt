package io.github.garykam.atsaplus.navigation

interface Destination {
    val route: String
}

object Home : Destination {
    override val route: String = "home"
}

object MemoryDifferenceWelcome : Destination {
    override val route: String = "memory_difference_welcome"
}

object MemoryDifference : Destination {
    override val route: String = "memory_difference"
}

object MemoryVariable : Destination {
    override val route: String = "memory_variable"
}