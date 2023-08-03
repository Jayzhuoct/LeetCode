package easy;


import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T104二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(maxDepth2(root));

    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数的空间复杂度取决于递归的栈深度，
     */
    public static int maxDepth1(TreeNode root) {
        // 如果根节点为空，返回0
        if (root == null) {
            return 0;
        }
        // 递归调用maxDepth方法，计算左子树的深度并加1
        int leftDepth = maxDepth1(root.left) + 1;
        // 递归调用maxDepth方法，计算右子树的深度并加1
        int rightDepth = maxDepth1(root.right) + 1;
        // 返回左右子树深度的较大值
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * 迭代法
     * @param root
     * @return
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在入队出队队列中各一次，故渐进时间复杂度为 O(n)。
     * 空间复杂度：O(n)，其中 n 为二叉树节点的个数。空间复杂度取决于队列中的元素个数，队列中的元素个数不会超过 n。
     */
    public static int maxDepth2(TreeNode root) {
        // 如果根节点为空，返回0
        if (root == null) {
            return 0;
        }
        // 创建一个队列，将根节点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 初始化ans为0，表示从根节点开始遍历
        int ans = 0;
        // 循环队列中的节点
        while (!queue.isEmpty()) {
            // 记录当前层的节点数
            int size = queue.size();
            while (size > 0) {
                // 从队列中取出节点
                TreeNode node = queue.poll();
                // 如果节点不为空且左子节点不为空，将左子节点加入队列
                if (node != null && node.left != null) {
                    queue.offer(node.left);
                }
                // 如果节点不为空且右子节点不为空，将右子节点加入队列
                if (node != null && node.right != null) {
                    queue.offer(node.right);
                }
                // 当前层的节点数减1
                size--;
            }
            // 完成一层的遍历，深度加1
            ans++;
        }
        // 返回二叉树的深度
        return ans;
    }
}
