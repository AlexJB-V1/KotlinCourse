package kotlinnull

import NullSafety
import model.Animal
import model.AnimalType
import model.AnimalType.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NullPointerException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class NullTests {

    private lateinit var nullSafety: NullSafety
    private lateinit var dog: Animal
    private lateinit var cat: Animal
    private lateinit var seal: Animal

    @BeforeEach
    fun setStage() {
        nullSafety = NullSafety()
        dog = Animal(name = "Rover", DOG, null, null, 0)
        cat = Animal(name = "Kitkat", CAT, 5, 200_000, 5)
        seal = Animal(name = "Seal", SEAL, 9, 0, 0)
    }


    @Test
    fun `Should get non-nullable age`() {
        val dogVal = nullSafety.getNonNullAge(dog)
        val catVal = nullSafety.getNonNullAge(cat)
        val sealVal = nullSafety.getNonNullAge(seal)

        assertEquals(0, dogVal)
        assertEquals(5, catVal)
        assertEquals(9, sealVal)
    }

    @Test
    fun `Should calculate steps`() {
        val dogVal = nullSafety.getNonNullTotalSteps(dog)
        val catVal = nullSafety.getNonNullTotalSteps(cat)
        val sealVal = nullSafety.getNonNullTotalSteps(seal)

        assertEquals(0, dogVal)
        assertEquals(1_000_000, catVal)
        assertEquals(0, sealVal)
    }

    @Test
    fun `Should calculate steps again with nullable`() {
        val dogVal = nullSafety.getNullableTotalSteps(dog)
        val catVal = nullSafety.getNullableTotalSteps(cat)
        val sealVal = nullSafety.getNullableTotalSteps(seal)

        assertEquals(null, dogVal)
        assertEquals(1_000_000, catVal)
        assertEquals(0, sealVal)
    }

    @Test
    fun `should throw NPE`() {

        assertEquals("ok", nullSafety.lowerCaseIfNotNull("Ok"))
        assertFailsWith<NullPointerException>(
            block = {
                nullSafety.lowerCaseIfNotNull(null)
            }
        )
    }




}