package medium;

import common.TreeNode;

public class T437路径总和III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        root.left = node1;
        TreeNode node2 = new TreeNode(-3);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        TreeNode node4 = new TreeNode(2);
        node1.right = node4;
        TreeNode node5 = new TreeNode(11);
        node2.right = node5;
        TreeNode node6 = new TreeNode(3);
        node3.left = node6;
        TreeNode node7 = new TreeNode(-2);
        node3.right = node7;
        TreeNode node8 = new TreeNode(1);
        node4.right = node8;
        System.out.println(pathSum(root, 8));
    }

    /*
        时间复杂度：O(n^2)，其中n是二叉树的节点数。对于每个节点，递归函数pathSum都可能遍历以它为根节点的子树。
        空间复杂度：O(n)，其中n是二叉树的节点数。空间复杂度主要取决于递归调用的栈空间，
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以当前节点为根节点的子树中满足条件的路径数量
        int res = dfs(root, targetSum);
        // 递归计算左子树中满足条件的路径数量，并累加到res上
        res += pathSum(root.left, targetSum);
        // 递归计算右子树中满足条件的路径数量，并累加到res上
        res += pathSum(root.right, targetSum);
        // 返回以当前节点为根节点的子树中满足条件的路径数量
        return res;
    }

    private static int dfs(TreeNode root, int targetSum) {
        // 如果当前节点为空，表示到达了子树的叶节点，返回0
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 如果当前节点的值等于targetSum，表示当前节点是一个满足条件的路径
        if (root.val == targetSum) {
            res++;
        }
        // 递归计算左子树中满足条件的路径数量，并累加到res上
        res += dfs(root.left, targetSum - root.val);
        // 递归计算右子树中满足条件的路径数量，并累加到res上
        res += dfs(root.right, targetSum - root.val);
        // 返回以当前节点为根节点的子树中满足条件的路径数量
        return res;
    }
}
