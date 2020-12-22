object Solution {
  def allIndexOf(s: String, value: String): List[Int] = {

    @scala.annotation.tailrec
    def func(result: collection.mutable.ListBuffer[Int], start: Int): collection.mutable.ListBuffer[Int] = {
      val index = s.indexOf(value, start)
      if (index != -1) {
        result.addOne(index)
      }

      if (index != -1 && index + value.length < s.length) func(result, start + value.length) else result
    }

    val result = collection.mutable.ListBuffer.empty[Int]
    func(result, 0).toList
  }

  def isExist(index: Int, targets: Set[Int], lens: Map[Int, Int], dict: Map[Int, Set[Int]]): Boolean = {
    if (targets.isEmpty) {
      return true
    }

    if (dict.contains(index)) {
      val intersect = dict(index).intersect(targets)
      intersect.size match {
        case 1 =>
          for (i <- intersect) {
            return isExist(index + lens(i), targets - i, lens, dict)
          }
        case i if i > 1 =>
          for (i <- intersect) {
            if (isExist(index + lens(i), targets - i, lens, dict)) {
              return true
            }
          }
        case _ => ()
      }
    }
    false
  }


  def findSubstring(s: String, words: Array[String]): List[Int] = {
    val len = words.map(_.length).sum
    val lens = words.zipWithIndex.map({ case (str, i) => i -> str.length }).toMap
    val dict = words.zipWithIndex
      .map({ case (str, i) => i -> allIndexOf(s, str) })
      .flatMap({ case (i, list) => list.map(_ -> i) })
      .groupBy(_._1)
      .map({ case (i, tuples) => i -> tuples.map(_._2).toSet })

    val targets = words.indices.toSet
    Range.inclusive(0, s.length - len).filter(i => dict.contains(i) && isExist(i, targets, lens, dict)).toList
  }


}