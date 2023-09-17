package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T872叶子相似的树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root1Left = new TreeNode(5);
        TreeNode root1Right = new TreeNode(1);
        TreeNode root1LeftLeft = new TreeNode(6);
        TreeNode root1LeftRight = new TreeNode(2);
        TreeNode root1RightLeft = new TreeNode(9);
        TreeNode root1RightRight = new TreeNode(8);
        TreeNode root1LeftRightLeft = new TreeNode(7);
        TreeNode root1LeftRightRight = new TreeNode(4);
        root1.left = root1Left;
        root1.right = root1Right;
        root1Left.left = root1LeftLeft;
        root1Left.right = root1LeftRight;
        root1Right.left = root1RightLeft;
        root1Right.right = root1RightRight;
        root1LeftRight.left = root1LeftRightLeft;
        root1LeftRight.right = root1LeftRightRight;

        TreeNode root2 = new TreeNode(3);
        TreeNode root2Left = new TreeNode(5);
        TreeNode root2Right = new TreeNode(1);
        TreeNode root2LeftLeft = new TreeNode(6);
        TreeNode root2LeftRight = new TreeNode(7);
        TreeNode root2RightLeft = new TreeNode(4);
        TreeNode root2RightRight = new TreeNode(2);
        TreeNode root2RightRightLeft = new TreeNode(9);
        TreeNode root2RightRightRight = new TreeNode(8);
        root2.left = root2Left;
        root2.right = root2Right;
        root2Left.left = root2LeftLeft;
        root2Left.right = root2LeftRight;
        root2Right.left = root2RightLeft;
        root2Right.right = root2RightRight;
        root2RightRight.left = root2RightRightLeft;
        root2RightRight.right = root2RightRightRight;

        System.out.println(leafSimilar(root1, root2));
    }

    /**
     * 比较两个二叉树的叶子节点序列是否相等
     * @param root1 第一个二叉树的根节点
     * @param root2 第二个二叉树的根节点
     * @return 如果叶子节点序列相等，则返回true；否则返回false
     * 时间复杂度：O(n1+n2)，其中 n1 和 n2 分别是两个二叉树的节点个数。
     * 对两个二叉树同时进行深度优先搜索，需要遍历的节点总数是 n1+n2。
     * 空间复杂度：O(n1+n2)，其中 n1 和 n2 分别是两个二叉树的节点个数。
     * 空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过 n1+n2。
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 创建一个列表用于存储第一个二叉树的叶子节点序列
        List<Integer> seq1 = new ArrayList<Integer>();
        // 如果第一个二叉树不为空，则进行深度优先搜索获取叶子节点序列
        if (root1 != null) {
            dfs(root1, seq1);
        }

        // 创建一个列表用于存储第二个二叉树的叶子节点序列
        List<Integer> seq2 = new ArrayList<Integer>();
        // 如果第二个二叉树不为空，则进行深度优先搜索获取叶子节点序列
        if (root2 != null) {
            dfs(root2, seq2);
        }

        // 比较两个叶子节点序列是否相等
        return seq1.equals(seq2);
    }

    /**
     * 深度优先搜索得到二叉树的叶子节点序列
     * @param node 当前节点
     * @param seq 用于存储叶子节点序列的列表
     */
    public static void dfs(TreeNode node, List<Integer> seq) {
        // 如果当前节点是叶子节点，则将其值加入到叶子节点序列中
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            // 如果当前节点不是叶子节点，则递归地对左右子节点进行深度优先搜索
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }
}
