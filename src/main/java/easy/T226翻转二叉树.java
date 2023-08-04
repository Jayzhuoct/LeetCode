package easy;

import common.TreeNode;

public class T226翻转二叉树 {
    public static void main(String[] args) {
        // 创建一个二叉树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        // 输出翻转后的二叉树的节点值
        root.printTreeByLevel(invertTree(root));


    }

    /**
     * 翻转二叉树
     *
     * @param root 二叉树的根节点
     * @return 翻转后的二叉树根节点
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            // 如果根节点为空，返回 null
            return null;
        }
        //前序
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归调用翻转函数
        invertTree(root.left);
        invertTree(root.right);
        return root;

        /*中序
        invertTreeInorder(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeInorder(root.left);
        return root;
         */


        /*后序
        invertTreePostorder(root.left);
        invertTreePostorder(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
         */

    }
}
