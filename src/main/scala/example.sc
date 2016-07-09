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


def fib(n : Int) = {

  @tailrec
  def helper(acc1 : Int, acc2: Int, n : Int) : Int = {
    if (n == 3)
      acc1 + acc2
    else
      helper(acc2, acc1 + acc2, n - 1)
  }
  if(n == 1 || n == 2){
    1
  } else {
    helper(1, 1, n)
  }
}

fib(5)
