package com.caocao.baseOP

import scala.collection.mutable.ListBuffer

/**
  * Created by m on 16-11-2.
  */
object SListOP {

  def main(args: Array[String]): Unit = {

    var fruit: List[String] = List("apples", "oranges", "pears")
    println(fruit.addString(new StringBuilder("orange")))

    fruit = "a" :: "b" :: fruit
    println(fruit)

    fruit = fruit ::: fruit
    println(fruit)
    //
    //    println(fruit.apply(2))
    //
    //    println(fruit.count(a => a.length > 3))
    //
    //
    //
    //
    //    println(fruit.drop(2))
    //    println(fruit.dropRight(2))
    //    println(fruit)
    //
    //    println(fruit.toStream.contains("apples"))
    //
    //    println(fruit.exists(s => s == "apples"))
    //
    //    println(fruit.filter(s => s.length == 5))
    //
    //    println(fruit.toStream.filter(s => s.startsWith("H")).size)
    //
    //    fruit.foreach(s => println(s))
    //    fruit.foreach(println)

    var loop = fruit;
    while (loop.size > 0) {
      println(loop.last)
      loop = loop.init
    }

    println(fruit.map(s => (s + "-caocao").reverse))


    val mul_fruits = ListBuffer[String]()
    mul_fruits.append("apple")
    mul_fruits += "banana"
    println(mul_fruits)

  }

}
