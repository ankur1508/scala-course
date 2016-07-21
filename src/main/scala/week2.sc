def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b)
      acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}

sum(x => x, 3, 5)

def product(f : Int => Int) (a: Int, b :Int) : Int = {
    if(a > b) 1 else f(a) * product(f)(a + 1, b)
}

product(x => x * x)(1, 3)

def fact(n : Int) : Int = {
  product(x => x)(1, n)
}

fact(4)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, init: Int)(a:Int, b: Int) : Int = {
  if(a > b)
    init
  else
    combine(f(a), mapReduce(f, combine, init)(a+1, b))
}

mapReduce(a => a, (x, y) => x * y, 1)(1, 3)








