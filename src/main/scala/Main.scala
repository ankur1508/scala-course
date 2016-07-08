package recfun

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
  def countChange(money: Int, coins: List[Int]): Int = ???
}

