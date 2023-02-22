import scala.collection.mutable.Map
import scala.collection.mutable.TreeSet

class NumberContainers() {

  val indexToNumber = Map.empty[Int, Int]

  val numberToIndices = Map.empty[Int, TreeSet[Int]]

  def change(index: Int, number: Int) {
    val previousNumber = indexToNumber.get(index)
    indexToNumber(index) = number
    previousNumber.foreach(prev => numberToIndices(prev).remove(index))
    numberToIndices.getOrElseUpdate(number, TreeSet.empty[Int]).add(index)
  }

  def find(number: Int): Int =
    numberToIndices.get(number).flatMap(_.headOption).getOrElse(-1)
}