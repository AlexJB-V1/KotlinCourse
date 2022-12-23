import model.Animal

class NullSafety {

//    fun getNonNullAge(animal: Animal): Int = TODO("Return 0 if age is null")
    fun getNonNullAge(animal: Animal): Int = animal.age ?: 0

//    fun getNonNullTotalSteps(animal: Animal): Int = TODO("Return 0 if steps or age are null")
    fun getNonNullTotalSteps(animal: Animal): Int = animal.age?.let { animal.stepsPerYear?.times(it) }?: 0

//    fun getNonNullTotalSteps(animal: Animal): Int = TODO("Return null if steps or age are null")
    fun getNullableTotalSteps(animal: Animal): Int? = animal.age?.let { animal.stepsPerYear?.times(it) }

//    fun lowerCaseIfNotNull(myString: String?): String = TODO("Method to return lower case if not null")
    fun lowerCaseIfNotNull(myString: String?): String = myString?.lowercase() ?: throw NullPointerException()


}