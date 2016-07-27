def queens(n: Int) : Set[List[Int]] = {
  def isSafe(col : Int, queens : List[Int]) : Boolean = {
    val row = queens.length
    val queensWithRows = (row - 1 to 0 by -1).zip(queens)
    true
    //queensWithRows.forall((r, c) => (c != col && math.abs(col - c) != row - r))
  }
  def placeQueens(k : Int) : Set[List[Int]] = {
    if(k == 0) Set(List())
    else {
      for{queens <- placeQueens(k -1)
      c <- 0 to n
      isSafe(c, queens)} yield c :: queens
    }
  }
  placeQueens(n)
}


val queens = List(2, 3, 0)
(2 to 0 by -1).zip(queens)

