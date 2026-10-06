/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if(root == null) return true
        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    fun isValidBST(root: TreeNode?, parentLeft: Int, parentRight: Int): Boolean {
        if(root == null) return true
        val currValue = root.`val`
        if(currValue <= parentLeft || currValue >= parentRight) {
            return false
        }
        return isValidBST(root.left, parentLeft, currValue) && isValidBST(root.right, currValue, parentRight)
    }
}
