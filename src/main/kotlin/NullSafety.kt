import model.Animal

class NullSafety {

    fun getNonNullAge(animal: Animal): Int = TODO("Return 0 if age is null")
    fun getNonNullTotalSteps(animal: Animal): Int = TODO("Return 0 if steps or age are null")
    fun getNullableTotalSteps(animal: Animal): Int? = TODO("Return null if steps or age are null")
    fun lowerCaseIfNotNull(myString: String?): String = TODO("Method to return lower case if not null")


}