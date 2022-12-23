## Default and Named Arguments in Kotlin

***

### Named Args

When calling a method, Kotlin gives you the option to specify the name of the arg you are passing, allowing you to
pass args in different order and to increase readability of the code.

`fun doSomething(a: Int, b: String) = ...`

All of these are valid ways of calling this method..
```
(a)

doSomething(1, "b")
doSomething(a = 1, b = "b")
doSomething(b = "b", a = 1)
doSomething(1, b = "b")

```

***


### Default Args


Kotlin also gives you the ability to specify a default value for a method arg- allowing a caller of the method to
optionally pass those args, or accept the default values


`fun doSomething(a: Int = 1, b: String = "b") = ...`

Named and default args can be used in combination. All of these are valid ways of calling this method..
```
(b)

DoSomething()           // a=1,b="b" - default being taken for both params
DoSomething(2)          // a=2,b="b" - default taken for b as no second param included
DoSomething(a = 2)      // a=2,b="b" - default taken for b as no second param included and named param is a
DoSomething(b = "c")    // a=1,b="c" - default taken for a as no second param included and named param is b

In addition, all of those from the block above (a) are also valid

```

***