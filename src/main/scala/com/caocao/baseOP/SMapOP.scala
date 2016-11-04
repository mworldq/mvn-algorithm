package com.caocao.baseOP

/**
  * Created by m on 16-11-2.
  */
object SMapOP {
  def main(args: Array[String]): Unit = {
    println("hello Map")

    var m = Map[String, Int]()
    //    var A: Map[String, Int] = Map()
    m += ("father" -> 35)
    m += ("mother" -> 34)
    m += ("grand-father" -> 63)
    m += ("grand-mother" -> 62)
    println(m)

    m.keys.foreach(println)

    m.values.foreach(println)

    println(m.getOrElse("father", 99))
    println(m.getOrElse("father_", 99))

    m -= "father"
    println(m)

    println(m.filterKeys(s => s.startsWith("g")))


    for (i <- m.keys) {
      println("key:" + i + ", value:" + m.getOrElse(i, -1))
    }

//    m.toList.sortWith(((s1, i1), (s2, i2)) => i1 > i2)

  }

}
