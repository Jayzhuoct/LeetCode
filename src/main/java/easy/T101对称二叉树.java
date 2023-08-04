package easy;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T101对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric1(root));
    }

    /*
    递归
    时间复杂度：O(n)，其中 n 是树的节点个数。
    空间复杂度：O(n)，其中 n 是树的节点个数。
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /*
    迭代
    * 1. 如果根节点为空，则整棵树是对称的
    * 2. 定义一个队列，将根节点的左右子节点分别入队
    * 3. 循环处理队列中的节点
    * 4. 取出队列中的两个节点，分别表示左右子树的对称节点
    * 5. 如果两个节点都为空，则继续处理队列中的下一对节点
    * 6. 如果一个节点为空，或者两个节点的值不相等，则整棵树不是对称的
    * 7. 将左节点的左子节点和右节点的右子节点入队
    * 8. 将左节点的右子节点和右节点的左子节点入队
    * 9. 如果队列为空时仍然没有发现不对称的节点，则说明整棵树是对称的
    * 时间复杂度：O(n)，其中 n 是树的节点个数。
    * 空间复杂度：O(n)，其中 n 是树的节点个数。
     */
    public static boolean isSymmetric1(TreeNode root) {
        // 如果根节点为空，则整棵树是对称的
        if (root == null) {
            return true;
        }

        // 定义一个队列，将根节点的左右子节点分别入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        // 循环处理队列中的节点
        while (!queue.isEmpty()) {
            // 取出队列中的两个节点，分别表示左右子树的对称节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // 如果两个节点都为空，则继续处理队列中的下一对节点
            if (left == null && right == null) {
                continue;
            }

            // 如果一个节点为空，或者两个节点的值不相等，则整棵树不是对称的
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // 将左节点的左子节点和右节点的右子节点入队
            // 将左节点的右子节点和右节点的左子节点入队
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        // 如果队列为空时仍然没有发现不对称的节点，则说明整棵树是对称的
        return true;
    }
}
