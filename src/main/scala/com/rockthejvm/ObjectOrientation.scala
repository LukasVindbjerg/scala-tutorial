package com.rockthejvm

object ObjectOrientation extends App {

  class Animal {
    val age: Int = 0

    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

 // inheritance
 class Dog(val name: String) extends Animal
 // constructor arguments are not fields. You need to put a 'val' before the constructor argument
 // This means you can't do Dog.name if it doesn't have val
 val aDog = new Dog("Max")

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Olga")
  aDeclaredAnimal.eat() // This  calls the most derived method. So it would call Dog.eat if it was defined

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default, everything is public, but it has private and protected
    private val numLegs: Int = 4
    def walk(): Unit
  }

  // We also have interfaces in Scala
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  // scala has single class inheritance and multi trait "mixing"
  trait Reptile

  class Crocodile extends Animal with Carnivore with Reptile {
    override def eat(animal: Animal): Unit = {
      println("Eating...")
    }

  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDeclaredAnimal // This notation is called "infix notation" as: 'object' 'method' 'argument'
  // Both above does the same. But it is only available with methods with a single argument.


  // Scala is very free when it comes tom method naming.
  def !?(idea: String): Unit = println(s"My idea is: $idea")

  // That looks much like an operator. Well in scala all operators are methods...

  val mathExample = 1 + 2
  // This '+' above is just a method of the Int type, meaning we can write it like this aswell:
  val uglyMathExample = 1.+(2)
  // This is the same as we use the '+' argument from 1's Int method with 2 as the argument


  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val myValue: Int = 5
    def myMethod(): Int = 123
    def apply(i: Int): Int = i + 1
  }

  MySingleton.myMethod()
  // The 'apply' method defined above is special. For anywhere, it can be defined, calling just class() or object() will call the apply method
  println(MySingleton(5)) // this is the same as MySingleton.apply(5)
  // The presence of an apply method within a class allows instances of that class to be invoked like functions.


  // A funny thing with objects (singletons) and classes is that they can have the same name.
  // This is called a companion object
  object Animal {
    // These companions can access each others private fields/methods
    // But, the singleton Animal and instances of the Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // like "static" fields/methods


  /* CASE CLASSES
     These are lightweight data structures that has some predefined boilerplate
     - sensible equals and hash code
     - serialization
     - companion with apply
     - pattern matching
  */
  case class Person(name: String, age: Int)

  // Since the case class has a companion with apply, we can simply create an instance without 'new'
  val bob = Person("bob", 34)
}
