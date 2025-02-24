package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  // These two does the same thing:
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
   * Scala runs on the JVM
   * Functional programming:
   * - compose functions
   * - pass functions as args
   * - return functions as results
   *
   * Conclusion: FunctionX = Function1, Function2, ..., Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // This is the same as above
  // We have basically defined a function

  // All scala functions are instance of these function_x types.

  // Function with two arguments and 2 return types
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(stringConcatenator("I love", " Scala"))

  // Syntax sugars. We can make this doubler function in so many ways
  val doubler1: Function1 [Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int): Int = 2 * x
  }
  // We can just do an arrow to define the functionality
  val doubler2: Function1[Int, Int] = (x: Int) => 2 * x
  doubler2(4) // 8

  // We can also just imit the Function[]
  val doubler3: Int => Int = (x: Int) => 2 * x

  // We can actually remove the type definition as the compiler can figure that out itself
  val doubler4 = (x: Int) => 2 * x

  // Higher-order functions (HOF): Take functions as args OR return function as result
  val aMappingList = List(1, 2, 3).map(x => x + 1) // HOF
  println(aMappingList)

  val aFlatMapList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }
  println(aFlatMapList)

  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x <= 3)
  val aShortFilteredList = List(1, 2, 3, 4, 5).filter(_ <= 3) // This does the same

  // Because we usually work with immutables in Scala, chaining is easy as everything returns a new instance

  // All the pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  print(allPairs)
  // This is a very good way of showing that we don't 'need' loops to do stuff in scala.
  // But it is a bit difficult to read (especially if it is more abstract logic then pairing lists)

  // for comprehensions (for is not a 'for-loop' like in Python
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatmap chain above

  /**
   * Collections
   */

  // lists
  val aList = List(1, 2, 3, 4)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0, 1, 2, 3, 4)
  val extendedList = 0 +: aList :+ 5 // List(0, 1, 2, 3, 4, 5)

  // Sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1, 2, 3)
  val accessedElement = aSequence(1) // returns element at that index '1' -> 2

  // vectors: Fast sequence implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets = no duplicates
  val aSet: Set[Int] = Set(1, 2, 3, 4, 5, 1, 2, 3)
  val setHas5 = aSet.contains(5) // boolean -> True here
  val anAddedSet = aSet + 6 // Set(1, 2, 3, 4, 5, 6)
  val aRemovedSet = aSet - 3 // Set(1, 2, 4, 5)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(_ * 2).toList // List(2, 4, 6, 8, ..., 2000)

  // tuples = groups of value under same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 123123),
    ("Tom", 2810481),
    "Jane" -> 212312 // this is the same but different notation
  )
}