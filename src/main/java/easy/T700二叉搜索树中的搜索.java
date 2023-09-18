package easy;

import common.TreeNode;

public class T700二叉搜索树中的搜索 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7);
        root.printTreeByLevel(searchBST1(root, 2));
    }

    /*
    递归
    思路：通过递归的方式在二叉搜索树中搜索指定值。
    时间复杂度：平均情况下为O(logN)，其中N是二叉搜索树中的节点数。最坏情况下为O(N)，当树为非平衡二叉树时。
    空间复杂度：平均情况下为O(logN)，最坏情况下为O(N)，取决于递归调用栈的深度。
 */
    public static TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST1(root.left, val);
        } else {
            return searchBST1(root.right, val);
        }
    }

    /*
        迭代
        思路：通过迭代的方式在二叉搜索树中搜索指定值。
        时间复杂度：平均情况下为O(logN)，其中N是二叉搜索树中的节点数。最坏情况下为O(N)，当树为非平衡二叉树时。
        空间复杂度：O(1)，只使用了常数级别的额外空间。
     */
    public static TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}