package io.github.garykam.atsaplus

fun IntRange.randomButExclude(exclude: Int): Int {
    val random = random()
    return if (random != exclude) random else randomButExclude(exclude)
}