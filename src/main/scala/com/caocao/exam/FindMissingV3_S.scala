package com.caocao.exam

/**
  *
  * 现在有一大堆自然数组成的小到大数组arr，其中会有123456910  这样就要找到6(最先不连续的数字)
  */
object FindMissingV3_S {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5, 6, 9, 1, 0)

    var i = 0
    while (a(i + 1) == a(i) + 1) {
      i = i + 1
    }

    println(a(i))
  }
}
