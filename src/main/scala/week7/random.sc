import java.util.Random

trait Generator[T] {
  self =>

  def generate : T

  def map[S](f: T => S) : Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]) : Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }
}

val integers = new Generator[Int] {
  val generator = new Random()
  def generate = generator.nextInt()
}

val booleans = new Generator[Boolean] {
  def generate = integers.generate > 0
}

val tuples = new Generator[Tuple2[Int, Int]] {
  def generate = (integers.generate, integers.generate)
}


