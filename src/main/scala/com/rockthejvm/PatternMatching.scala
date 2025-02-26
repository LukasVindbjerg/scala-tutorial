package com.rockthejvm

object PatternMatching extends App{

  // switch "expressions"
  val anInteger: Int = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order)
  // pattern matching is again an expression (like everything else in Scala)

  // Case class decomposition
  case class Person(name: String, age: Int)
  val bob = new Person("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is ${n} and I am $a years old."
    case _ => "Something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "IDK"
  }

  val aList = List(1, 2, 3)
  val listDescription = aList match{
    case List(_, 2, _) => "This list has a 2 on its second location"
    case _ => "Unknown list"
  }
  // Good practice is to always include the _ case as otherwise it will throw a MatchError
  // PM will try all cases in sequence. Meaning that if we start with _ it will always be matched
}
