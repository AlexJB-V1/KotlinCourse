package kotlinnull

import NamedAndDefaultArguments
import model.Building
import model.BuildingToEdit
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NamedArgumentsTests {

    private lateinit var namedAndDefaultArguments: NamedAndDefaultArguments

    private lateinit var building1: Building
    private lateinit var buildingToEdit: BuildingToEdit

    @BeforeEach
    fun setScene() {
        namedAndDefaultArguments = NamedAndDefaultArguments()
        building1 = Building()
        buildingToEdit = BuildingToEdit()
    }

    @Test
    fun `Should validate with named args`() {

        var isBreezy = false

        // TODO Uncomment and make this compile without changing the order of the params or editing the method being called (i.e. 0=ac, 1=windows)
//        namedAndDefaultArguments.isBreezy(
//            doors = building1.doors,
//            building1.hasAc,
//            building1.windows
//        )

        assertTrue(isBreezy)

    }

    @Test
    fun `Should validate by changing default args on data class BuildingToEdit`() {

        val newBuildingToEdit = namedAndDefaultArguments.doubleDoors(buildingToEdit)

        // TODO Update only the data class BuildingToEdit to pass these tests
        assertEquals(14, newBuildingToEdit.doors)
        assertEquals(3, newBuildingToEdit.windows)
        assertEquals(true, newBuildingToEdit.hasAc)

    }



}