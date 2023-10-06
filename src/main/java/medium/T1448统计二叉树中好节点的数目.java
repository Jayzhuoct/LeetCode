package medium;

import common.TreeNode;
public class T1448统计二叉树中好节点的数目 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        TreeNode node2 = new TreeNode(4);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        TreeNode node4 = new TreeNode(1);
        node1.right = node4;
        TreeNode node5 = new TreeNode(5);
        node2.right = node5;
        System.out.println(goodNodes(root));
    }

    /*
        时间复杂度：O(n)，其中n是二叉树的节点数。每个节点在递归中只被遍历一次。
        空间复杂度：O(n)，其中n是二叉树的节点数。空间复杂度主要取决于递归调用的栈空间，
        递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点数。
     */
    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    // 递归函数，用于计算以当前节点为根节点的子树中的“好节点”数量
    public static int dfs(TreeNode root, int max) {
        // 如果当前节点为空，表示到达了子树的叶节点，返回0
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 如果当前节点的值大于等于max，表示当前节点是一个“好节点”
        if (root.val >= max) {
            res++;
            max = root.val; // 更新max为当前节点的值，用于后续子树的判断
        }
        // 递归计算左子树中的“好节点”数量，并累加到res上
        res += dfs(root.left, max);
        // 递归计算右子树中的“好节点”数量，并累加到res上
        res += dfs(root.right, max);
        // 返回当前子树中的“好节点”数量
        return res;
    }
}
