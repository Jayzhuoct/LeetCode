package easy;

import common.TreeNode;

public class T543二叉树的直径 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    /*
        深度优先搜索

        时间复杂度分析：
        由于每个节点都会被访问一次，因此时间复杂度为 O(N)，其中 N 是二叉树中节点的总数。

        空间复杂度分析：
        由于递归调用会使用函数调用栈，最坏情况下，函数调用栈的深度等于二叉树的高度。
        对于平衡二叉树，高度为 log(N)，对于非平衡二叉树，高度最大为 N。
        因此，空间复杂度为 O(N) 或 O(log(N))，取决于二叉树的形状。
     */
    static int ans;
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = depth(root.left);// 左子树的最大深度
        int R = depth(root.right);// 右子树的最大深度
        ans = Math.max(ans, L + R + 1);// 左右子树的最大深度和
        return Math.max(L, R) + 1;// 返回当前节点的最大深度
    }
}
