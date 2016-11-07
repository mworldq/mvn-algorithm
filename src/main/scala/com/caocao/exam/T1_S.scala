package com.caocao.exam

import scala.io.Source

/**
  * Created by m on 16-11-3.
  */
object T1_S {

  val enum: Array[Char] = Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

  val root: TireNode = new TireNode()

  var productIdMap: Map[String, Int] = Map();

  def main(args: Array[String]): Unit = {
    readFile("./src/main/resources/order_ids.txt")
    iterator()
    getTopK()
  }

  def readFile(path: String): Unit = {
    Source.fromFile(path).getLines().foreach(productId => buildTriedTree(productId))
  }

  def buildTriedTree(productId: String): Unit = {
    println("productId = " + productId)
    addProductId2Tree(productId)
  }

  def addProductId2Tree(productId: String): Unit = {
    //    productId.foreach(println)
    var tn: TireNode = root
    for (ch <- productId.toCharArray) {
      if (!tn.children.keys.exists(key => key.equals(ch))) {
        tn.children += (ch -> new TireNode())
      }
      tn = tn.children.get(ch).get
    }
    tn.count = tn.count + 1
    tn.terminal = true
  }

  def iterator(): Unit = {
    val productId: StringBuilder = StringBuilder.newBuilder
    iteratorTree(root, productId)
  }


  def iteratorTree(tn: TireNode, tmp: StringBuilder): Unit = {
    if (tn.terminal) {
      println("productId:" + tmp.toString() + ", count:" + tn.count)
      productIdMap += (tmp.toString() -> tn.count)
      if (tn.children.isEmpty) {
        return
      }
    }
    for (key <- tn.children.keys) {
      iteratorTree(tn.children.get(key).get, tmp.append(key))
      tmp.deleteCharAt(tmp.length - 1)
    }
  }

  def getTopK(): Unit = {
    println(productIdMap.toList.sortBy(_._2).reverse)
    val topK = productIdMap.toList.sortBy(_._2).reverse.take(2)
    println("topK = " + topK)
  }

  class TireNode {
    var count: Integer = 0;
    var terminal: Boolean = false;
    var children: Map[Char, TireNode] = Map();
  }

}
