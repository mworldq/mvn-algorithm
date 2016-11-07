package com.caocao.exam

/**
  * Created by m on 16-11-7.
  */
object MiniStack_S {

  var standList: List[Int] = List()
  var minList: List[Int] = List()

  def min(): Int = {
    return minList.head
  }

  def pop(): Int = {
    val head = standList.head
    standList = standList.drop(1)
    minList = minList.drop(minList.indexOf(head))
    return head
  }

  def push(a: Int): Unit = {
    standList = a :: standList
    minList = a :: minList
    minList = minList.sorted(Ordering.Int)
  }

  def main(args: Array[String]): Unit = {
    this.push(33)
    this.push(22)
    this.push(44)
    this.push(4)
    this.push(11)
    this.push(44)

    println("standList = " + standList)
    println("minList = " + minList)
    println("min = " + this.min())

    this.pop()
    this.pop()

    println("standList = " + standList)
    println("minList = " + minList)
    println("min = " + this.min())


  }

}
