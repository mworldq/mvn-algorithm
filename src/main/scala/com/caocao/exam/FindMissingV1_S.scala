package com.caocao.exam

/**
  *
  */
object FindMissingV1_S {
  def main(args: Array[String]): Unit = {
    val a = Array(0, 1, 2, 3, 4, 6, 7, 8)

    var n: Map[Int, Int] = Map()

    for( i <- 0 to a.length-1){
      n += (i -> a(i))
    }

    for( i <- 0 to a.length-1){
      n -= a(i)
    }

    print(n.keys)
  }
}
