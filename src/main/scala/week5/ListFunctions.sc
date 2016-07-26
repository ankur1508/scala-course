import scala.annotation.tailrec

def take[T](list : List[T], n : Int) : List[T] = {
  list match {
    case Nil => throw new Error("Empty list")
    case (x :: xs) =>  if(n == 1) List(x) else x :: take(xs, n - 1)
  }
}

val sample = List("banana", "apple", "grapes", "lemon")
assert(take(sample, 2) == sample.take(2), "Correct implememtation")

def drop[T](list : List[T], n : Int) : List[T] = {
  list match {
    case Nil => throw new Error("Empty list")
    case (x :: xs) =>  if(n == 1) xs else drop(xs, n - 1)
  }
}
assert(drop(sample, 2) == sample.drop(2), "Correct implememtation")

def remove[T](list : List[T], n : Int) : List[T] = take(list, n) ::: drop (list, n + 1)
remove(sample, 2)

def flatten(xs: List[Any]): List[Any] = {

  xs match {
    case Nil => Nil
    case y :: ys => {
      y match {
        case z :: zs => z :: flatten(zs) ::: flatten(ys)
        case z => z :: flatten(ys)
      }
    }
  }
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))

def msort(list: List[Int]) : List[Int] = {
  val n = list.length / 2
  if(n == 0) list
  else {
    val (first, second) = list.splitAt(n)
    def merge(xs : List[Int], ys : List[Int]) : List[Int] = {
      (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case ((x :: xs1), (y :: ys1)) => {
          if(x < y) x :: merge(xs1 , ys)
          else y :: merge(xs, ys1)
        }
      }
    }
    merge(msort(first), msort(second))
  }
}

msort(List(10, 9 , 5, 16, 35, 20))

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>{
    val (eq, diff) = xs.span(y => y == x)
    List(eq) ::: pack(diff)
  }
}
pack(List("a", "a", "a", "b", "c", "c", "a"))


def encode[T](xs : List[T]) : List[(T, Int)] = {
  val lists : List[List[T]] = pack(xs)
  def helper[T](lists: List[List[T]]) :  List[(T, Int)] = lists match {
    case Nil => Nil
    case (y :: ys1) => (y.head, y.length) :: helper(ys1)
  }
  helper(lists)
}

encode(List("a", "a", "a", "b", "c", "c", "a"))


val nos = List(10, 9 , 5, 16, 35, 20)
nos.reduceLeft(_ + _)

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())((x, y) => f(x) :: y)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((x, y) => y + 1)

lengthFun(List("a", "a", "a", "b", "c", "c", "a"))