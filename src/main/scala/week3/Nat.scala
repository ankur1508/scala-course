package week3

import scala.annotation.tailrec

/**
  * Created by asrivast on 7/15/16.
  */
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if(that isZero) Zero else throw new Error()

  override def predecessor: Nat = throw new Error()
}

class Succ(n : Nat) extends Nat {
  override def isZero: Boolean = false

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat = if(that isZero) this else n - that.predecessor

  override def predecessor: Nat = n
}