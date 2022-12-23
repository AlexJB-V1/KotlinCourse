package model

data class Building(
    val windows: Int = 10,
    val doors: Int = 5,
    val hasAc: Boolean = false,
    val capacity: Int = 100
)

data class BuildingToEdit( // TODO edit this class for `Should validate by changing default args on data class BuildingToEdit)`
    val windows: Int = 10,
    var doors: Int = 5,
    val hasAc: Boolean = false,
    val capacity: Int = 100
)
