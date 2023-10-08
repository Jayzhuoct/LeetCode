package medium;

import common.TreeNode;

public class T1372二叉树中的最长交错路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.left.right = new TreeNode(1);
        System.out.println(longestZigZag(root));
    }

    /**
     * 递归遍历二叉树节点
     * @param root 二叉树根节点
     * @return 二叉树中的最长 ZigZag 路径长度
     * 时间复杂度 O(n)，n 为二叉树节点数
     * 空间复杂度 O(n)，递归栈的深度
     */
    public static int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        dfs(root, res, true); // 从左子树开始遍历
        dfs(root, res, false); // 从右子树开始遍历
        return res[0];
    }

    /**
     * 递归遍历二叉树节点
     * @param root 当前节点
     * @param res 保存最长 ZigZag 路径长度的数组
     * @param isLeft 是否从左子树开始遍历
     * @return 当前节点为根的子树中的最长 ZigZag 路径长度
     */
    public static int dfs(TreeNode root, int[] res, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res, true); // 递归遍历左子树
        int right = dfs(root.right, res, false); // 递归遍历右子树
        res[0] = Math.max(res[0], Math.max(left, right)); // 更新最长 ZigZag 路径长度
        return (isLeft ? right : left) + 1; // 返回当前节点为根的子树中的最长 ZigZag 路径长度
    }
}
