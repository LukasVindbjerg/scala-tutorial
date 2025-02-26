package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  /** Lazy evalation */
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = { // Code block
    println("I am so very lazy")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // Lazy values are useful in infinite collections

  /**  "pseudo-collections": Option, Try */
  def methodWhichCanReturnNull(): String = "Hello, Scala"
  def anOption = Option(methodWhichCanReturnNull())
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // also works on: map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valiid value $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }
  /** Async porgramming
   * Evaluation on another thread
   * */

  val aFuture = Future{
    println("Waiting...")
    Thread.sleep(1000)
    println("I have waited")
    67
  }
  Thread.sleep(1500)
  // future is a "collection" which contains a value when it is evaluated
  // It is composable with map. flatMap and filter
  // monads

  /**
   * Implicits basicas
   * */
  // Two common use-cases
  // UC 1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46

  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // UC 2: Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven(): Boolean = n % 2 == 0
  }

  println(23.isEven())

}