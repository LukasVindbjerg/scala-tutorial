package com.rockthejvm

object Basics extends App {

  // Defining a value
  // Int, Boolean, Char, Double, Float, String

  val aNumber: Int = 123 // c++ equivalent: const int number = 42;

  val aBool = false

  // String operators
  val aString = "This is Scala"
  val aComposedString: String = "This" + " " + "is" + " " + "composed"
  val anInterpolatedString = s"After 122 comes $aNumber"

  // expressions: Structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  /*
  * So everything in scala is an expression.
  * Unlike typical languages with instructions such as "do this until some limit or bool=false"
  * Everything is boiled down to an expression
  * */
  val ifExpressionExample = if (anExpression < aNumber) 789 else 987
  // The above thing is an expression. The compiler sees it as 'val ifExpressionExample: Int' and not an operator

  // Because of this we can easily chain this as much as we like:
  val chainedIfExpressionExample =
    if (aNumber > 222) 69
    else if (aNumber < 14) 96
    else if (aNumber > 1000) 133
    else 0
  // All of this is still just an expression as it can be reduced to a single value

  // Code blocks are some things Scala can do as well (Still expressions though)
  val aCodeBlock = {
    // We can define local values, functions, classes, etc.
    // definitions
    val aLocalInt: Int = 67

    // At the end we have to return something as the 'expression'
    // Value of block is the value of the last expression
    aLocalInt + 3
  }

  // scala is a functional programming language so we of course have functions
  def aFunction(argInt: Int, argStr: String): String = {
    argStr + " " + argInt
  }

  // The notorious factorial recursive function
  def factorial(n: Int): Int ={
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // In Scala, we don't use loops or iteration, we use RECURSION!

  // Lastly the Unit type. This has no meaningful value unlike everything until now that has been expressed as Int, Str, ...
  // Unit type === "void" - it is like a side effect like println or sending some info to a socket
  // So a function can essentially be void like normal if we do this
  def unitFunction(): Unit = {
    println("Printing from a unit function")
  }

  
}
