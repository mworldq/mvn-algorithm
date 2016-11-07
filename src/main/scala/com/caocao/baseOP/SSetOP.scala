package com.caocao.baseOP

import scala.collection.mutable.Set;
;

/**
  * Created by m on 16-11-2.
  */
object SSetOP {
  def main(args: Array[String]): Unit = {
    println("hello = " + args)

    var s = Set[String]();
    s.add("caocao")
    s += "qinqin"
    s += "mm"
    s += "qq"
    for (singleS <- s) {
      println("singleS = " + singleS)
    }

    s -= "qinqin"
    println(s)

    println(s.exists(s => s.length == 6))

    println(s.filter(_.startsWith("c")))

    println(s.map(singleS => singleS + "").toList.sortWith((s1, s2) => s1 > s2))

    println(s.toList.sorted(Ordering.String.reverse))
  }

}
