abstract class IntSet{
  def incl(x : Int) : IntSet
  def contains(x : Int) : Boolean
  def union(other : IntSet) : IntSet
}

object Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  def contains(x: Int): Boolean = false

  def union(other : IntSet) : IntSet = other

  override def toString() = "."

}

class NonEmpty(element: Int, left : IntSet, right : IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if(x < element)
      new NonEmpty(element, left incl x, right)
    else if(x > element)
      new NonEmpty(element, left, right incl x)
    else
      this
  }

  def contains(x: Int): Boolean = {
    if(x < element)
      left contains  x
    else if(x < element)
      right contains  x
    else
      true
  }

  def union(other : IntSet) : IntSet =
    ((left union right) union other) incl element

  override def toString() = {
    left + "-" + element + "-" + right
  }
}

var tree = Empty.incl(5)
tree = tree.incl(8)
tree = tree.incl(2)
tree
