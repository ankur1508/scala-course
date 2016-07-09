package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))
    println(countChange(4, List(1, 2)))

  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if(c == 0 || c == r)
      1
    else
      pascal(c-1, r -1) + pascal(c, r-1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def helper(res: Boolean, braces: List[Char], char : Char, chars : List[Char]) : Boolean = {
      if (chars.isEmpty) {
        if (braces.isEmpty && char != '(' && char != ')')
          res
        else if (char == ')') {
          if(!braces.isEmpty && braces.tail.isEmpty)
            res & true
          else
            res & false
        }
        else
          res & false
      }
      else {
      if (char == '(')
        helper(res, '(' :: braces, chars.head, chars.tail)
      else if (char == ')') {
        if (!braces.isEmpty && braces.head == '(')
          helper(res, braces.tail, chars.head, chars.tail)
        else
          helper(res & false, braces, chars.head, chars.tail)
      } else {
        helper(res, braces, chars.head, chars.tail)
      }
    }
    }
    helper(true, List(), ' ', chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count( n: Int, m: Int ): Int = {
      if (n < 0 || m <= 0)
        0
      else if (n == 0)
        1
      else
        count(n, m - 1) + count(n - coins(m - 1), m)
    }
    count(money, coins.size)
  }
}

