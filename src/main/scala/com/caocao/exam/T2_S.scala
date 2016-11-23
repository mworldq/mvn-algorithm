package com.caocao.exam

/**
  * Created by m on 16-11-22.
  *
  * 给一列无序数组，求出中位数并给出算法的时间复杂度。
  */
object T2_S {

  def main(args: Array[String]): Unit = {
    val a = Array(6, 4, 2, 8, 9, 1, 0, 4)
    val b = a.sorted(Ordering.Int)
    println("b = " + b.toList)
    println("mid:" + b(b.length/2))
  }
}
