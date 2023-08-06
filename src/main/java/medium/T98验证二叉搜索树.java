package medium;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class T98验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST(root));
        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        System.out.println(isValidBST1(root1));

    }


    /*
    递归
    时间复杂度：O(n)，其中 n 是树的节点个数。
    空间复杂度：O(n)，其中 n 是树的节点个数。
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 判断以node为根的子树是否是有效的二叉搜索树
     * @param node 当前节点
     * @param min  当前节点的最小允许值（不包括）
     * @param max  当前节点的最大允许值（不包括）
     * @return     是否是有效的二叉搜索树
     */
    public static boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }

        // 检查节点的值是否符合范围
        if ((min != null && node.val <= min.val) || (max != null && node.val >= max.val)) {
            return false;
        }

        // 递归检查左子树和右子树
        // 对于左子树，当前节点是最大允许值
        // 对于右子树，当前节点是最小允许值
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }

    /*
    中序遍历
    首先，创建一个栈 stack 用于辅助遍历节点。初始化 inorder 为负无穷大。
    然后，进行迭代遍历直到栈为空且当前节点为空。在遍历过程中，首先将节点的左子节点依次入栈，直到左子节点为空。然后，从栈中弹出一个节点作为当前节点，并进行如下判断：
    如果当前节点的值小于等于 inorder，说明不满足二叉搜索树的条件，返回 false。
    更新 inorder 为当前节点的值。
    将当前节点的右子节点作为下一个遍历的节点。
    最后，如果遍历完成没有出现不满足条件的情况，则返回 true，表示二叉树是有效的二叉搜索树。
    时间复杂度：O(n)，其中 n 是树的节点个数。
    空间复杂度：O(n)，其中 n 是树的节点个数。
     */
    public static boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
