package medium;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T1161最大层内元素和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null,
                new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(maxLevelSum(root));
    }

    /*
        广度优先搜索
     */
    public static int maxLevelSum(TreeNode root) {
        // 创建一个队列，用于存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);
        // 创建一个变量，用于记录最大层内元素和
        int maxSum = Integer.MIN_VALUE;
        // 创建一个变量，用于记录最大层的层数
        int maxLevel = 0;
        // 创建一个变量，用于记录当前层的层数
        int level = 0;
        // 遍历队列，直到队列为空
        while (!queue.isEmpty()) {
            // 将当前层的节点个数记录下来
            int size = queue.size();
            // 创建一个变量，用于记录当前层的元素和
            int sum = 0;
            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                // 弹出队首的节点
                TreeNode node = queue.poll();
                // 将节点的值加入当前层的元素和
                sum += node.val;
                // 如果节点的左子节点不为空，则将其入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果节点的右子节点不为空，则将其入队
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 将当前层的层数加1
            level++;
            // 如果当前层的元素和大于最大层内元素和
            if (sum > maxSum) {
                // 更新最大层内元素和
                maxSum = sum;
                // 更新最大层的层数
                maxLevel = level;
            }
        }
        // 返回最大层的层数
        return maxLevel;
    }
}
