package medium;

import common.TreeNode;

public class T236二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode p1 = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(0);
        TreeNode p4 = new TreeNode(8);
        TreeNode p5 = new TreeNode(7);
        TreeNode p6 = new TreeNode(4);
        root.left = p;
        root.right = q;
        p.left = p1;
        p.right = p2;
        q.left = p3;
        q.right = p4;
        p2.left = p5;
        p2.right = p6;
        TreeNode res = lowestCommonAncestor(root, p, p6);
        System.out.println(res.val);
    }

    /*
        递归解法
        1. 递归终止条件：如果当前节点为空或者等于p或者等于q，直接返回当前节点
        2. 递归左子树：如果左子树返回为空，说明在右子树上
        3. 递归右子树：如果右子树返回为空，说明在左子树上
        4. 如果左右子树都不为空，说明在当前节点上
        时间复杂度：O(n)，n为二叉树节点数
        空间复杂度：O(n)，n为二叉树节点数，递归栈的深度
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null || root == p || root == q) return root;
        // 递归左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树为空，说明在右子树上
        if (left == null) return right;
        // 如果右子树为空，说明在左子树上
        if (right == null) return left;
        // 如果左右子树都不为空，说明在当前节点上
        return root;
    }
}
