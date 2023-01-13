# Null Safety in Kotlin
###### https://kotlinlang.org/docs/null-safety.html

To quote the link above, "_Kotlin's type system is aimed at eliminating the danger of null references, also known as The Billion Dollar Mistake._"

Kotlin has a key difference vs Java in that it's type system has 2 different concepts - 
Types that can hold a null reference and Types that cannot.

These are distinguished using `?`

`var myString` - Cannot hold a null reference

`var myString?` - Can hold a null reference


***

## Vs Java
### 'A' Java way

Imagine we want to work on a String, which is first created as null

`String myString = null;`


Now, lets say we want to work on this String and show the name in lower case. Unfortunately, we have forgotten to
give the String a value and it remains null. In Java, we would try..

```
        String myString = null;
        System.out.println(myString.toLowerCase());
```

However, as `myString` is null, calling `toLowerCase()` on a null reference will result in us throwing a `NullPointerException`
and our program falling over if we aren't handling this exception.

A simple Java solution could look like this...
```
        String myString = null;
        if (myString != null) {
            System.out.println(myString.toLowerCase());
        }
```

***

## The Kotlin Way


Imagine we want to work on the same String, which is again, first created as null

`var myString: String = null` // **Does Not Compile** ... We cannot set a non-nullable `String` to null

***


Very similar code, again..
```
    var myString: String? = null
    println(myString.toLowerCase())
```
This **does not compile** as we are trying to unsafely access a method `toLowerCase()` on a nullable type

_The begins to show how Kotlin's nullable protects our code from NPE's (NullPointerException's)_

***

We can however, safely work on this String via... this code compiles, runs and does not error - the String is evaluated to
be null and as such, the block within `let` is just ignored...
```
    var myString: String? = null
    myString?.let { println(it.toLowerCase()) }
```

This is called a `Safe Call - ?.`

Safe calls can be chained with nested nullable objects like..

`a?.b?c?.d`

***


If we were to give `myString` a value, we would then print it in lower case
```
    var myString: String? = "Hello"
    myString?.let { println(it.toLowerCase()) }
```

***

Kotlin Does not stop us from accessing the value in a more 'java-like' way though...
```
    var myString: String? = null
    if (myString != null) println(myString.toLowerCase())
```
The above will not print, but it will compile and run without exception

***

## Other Examples
In the above examples, we have focused on local variables, however, Nullable is used natively across all types

***

### Method args
```
fun doSomething(myString: String?) = ...

doSomething(null)       // Ok
doSomething("A String") // Ok

Whereas... (note the removed `?` below)

fun doSomething(myString: String) = ...

doSomething(null)       // Won't compile
doSomething("A String") // Ok
```
***


### Object properties

```
data class Animal(val name: String, val type: AnimalType, val age: Int?, val stepsPerYear: Int?, val treats: Int?)

    val animal = Animal( // This will compile because only nullable props are passed null
        "Rover",
        DOG,
        null,
        null,
        null
    )
    
        val animal = Animal( // This would not compile because non-nullable props are passed null
        null,
        null,
        1,
        2,
        3
    )
```
***

## Really want an NPE?

Kotlin will allow our code to throw NPE's under certain circumstances


### !!

If we use the `!!` operator, we open up the risk of NPE's. It can be used in place of a safe call `.?` to assert that
the value must not be null - otherwise an NPE will be thrown

#### Example
Going back to our use of `let` from earlier..

```    
    var myString: String? = null
    myString?.let { println(it.toLowerCase()) }
```

If we replace our safe call with `!!`..

```    
    var myString: String? = null
    myString!!.let { println(it.toLowerCase()) }    // This will compile and force an NPE
```

### Throw

`throw NullPointerException()`

### Other, specific scenario's
See `Data inconsistency with regard to initialization, such as when:` - https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types