import scala.annotation.tailrec

"Hello World!!"

def and(x:Boolean, y:Boolean) = if(x) y else false

and(true, true)
and(true, false)
and(false, true)
and(false, false)

def or(x:Boolean, y: => Boolean) = if(x) true else y
or(true, true)
or(true, false)
or(false, true)
or(false, false)


def factorial(x : Int) : Int = {
  @tailrec
  def factorialHelper(res : Int, n : Int) : Int = {
    if (n == 0)
      res
    else
      factorialHelper(res * n, n - 1)
  }
  factorialHelper(1, x)
}

factorial(4)



