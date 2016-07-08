def abs(x : Double) = if(x > 0) x else -x

def sqrt(x : Double) : Double = {
  def mean(x: Double, y: Double) = (x + y)/2

  def square(x: Double)  = x * x

  def goodEnoughGuess(guess: Double, x: Double) =
    abs(x - square(guess))/x < 0.001

  def sqrtIter(x : Double, guess : Double) : Double = {
    if(goodEnoughGuess(guess, x))
      guess
    else
      sqrtIter(x, mean(guess, x/guess))

  }

  sqrtIter(x, 1)
}

sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)


