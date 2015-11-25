/**
 * Created by semanticer on 19. 11. 2015.
 */
class Some(val v: Int, val l: TreeNode, val r: TreeNode) extends TreeNode {

  override def isIn(searchedVal: Int): Boolean = {
    if( v == searchedVal) true
    else if (v > searchedVal) l.isIn(searchedVal)
    else r.isIn(searchedVal)
  }

  override def depth: Int = ???

  override def add(newVal: Int): TreeNode = {
    if (v > newVal) ???
    else ???
  }

  override def select(i: Int): Int = ???
}
