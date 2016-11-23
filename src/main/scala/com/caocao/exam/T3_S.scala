package com.caocao.exam

/**
  * Created by m on 16-11-22.
  */
object T3_S {

  def main(args: Array[String]): Unit = {
    val a: UnionFind[String] = new UnionFind[String]
    a.union("s1", "s2")
    a.union("s3", "s4")
    a.union("s1", "s3")
    a.union("s5", "s6")
    a.union("s6", "s7")

//    println(a.find("Hello"))
    println(a.find("s5"))
    println(a.find("s2"))
  }

  class UnionFind[T] {

    var unionMap: Map[T, T] = Map()
    val unionSize: Map[T, Int] = Map()


    def find(key: T): Option[T] = {
      println("Find:" + key)
      if (!unionMap.keySet.contains(key)) {
        return None
      }

      var groupId = unionMap.get(key).get
      var _key = key
      while (!groupId.equals(_key)) {
        unionMap -> (_key, unionMap.get(unionMap.get(_key).get))
        _key = groupId
        if(!unionMap.keySet.contains(_key)){
          return None
        }
        groupId = unionMap.get(_key).get
      }
      return Some(groupId)
    }

    def union(t1: T, t2: T): Unit = {
      if (!unionMap.keySet.contains(t1)) {
        unionMap += (t1 -> t1)
      }
      if (!unionMap.keySet.contains(t2)) {
        unionMap += (t2 -> t2)
      }

      val root1: T = this.find(t1).get
      val root2: T = this.find(t2).get

      if (root1.equals(root2)) {
        return
      }
      unionMap += (root1 -> root2)
    }

  }

}
