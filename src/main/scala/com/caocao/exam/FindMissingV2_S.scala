package com.caocao.exam

/**
  *
  */
object FindMissingV2_S {
  def main(args: Array[String]): Unit = {
    val a = Array(0, 1, 2, 3, 4, 6, 7, 8)
    var i = 0
    while (i == a(i)) {
      i = i + 1
    }
    println(i)
  }
}
