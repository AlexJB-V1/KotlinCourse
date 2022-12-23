import model.BuildingToEdit

class NamedAndDefaultArguments {

    fun isBreezy(doors: Int, windows: Int, hasAc: Boolean): Boolean = (doors > 4 && windows > 3) && hasAc

    fun doubleDoors(buildingToEdit: BuildingToEdit): BuildingToEdit = buildingToEdit.apply {
        this.doors = this.doors * 2
    }

}