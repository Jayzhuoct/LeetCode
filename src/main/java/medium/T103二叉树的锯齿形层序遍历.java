package medium;

import common.TreeNode;

import java.util.*;

public class T103二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null,
                new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(zigzagLevelOrder(root));
    }

    /*
        广度优先搜索

        时间复杂度：O(n)，其中 n 是二叉树的节点数。每个节点会且仅会被遍历一次。
        空间复杂度：O(n)。空间复杂度取决于队列开销，队列中的节点个数不会超过 n。
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 创建一个结果集合，用于存储最终的层序遍历结果
        List<List<Integer>> ans = new LinkedList<List<Integer>>();

        // 如果根节点为空，直接返回结果集合
        if (root == null) {
            return ans;
        }

        // 创建一个队列，用于层序遍历
        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();

        // 将根节点加入队列
        nodeQueue.offer(root);

        // 用于标记当前层的遍历方向，初始为从左到右
        boolean isOrderLeft = true;

        // 开始层序遍历
        while (!nodeQueue.isEmpty()) {
            // 创建一个双端队列，用于存储当前层的节点值
            Deque<Integer> levelList = new LinkedList<Integer>();

            // 获取当前层的节点数量
            int size = nodeQueue.size();

            // 遍历当前层的所有节点
            for (int i = 0; i < size; ++i) {
                // 出队一个节点
                TreeNode curNode = nodeQueue.poll();

                // 根据遍历方向判断将节点值添加到双端队列的头部还是尾部
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }

                // 将当前节点的左子节点加入队列
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }

                // 将当前节点的右子节点加入队列
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }

            // 将当前层的节点值添加到结果集合中
            ans.add(new LinkedList<Integer>(levelList));

            // 切换遍历方向
            isOrderLeft = !isOrderLeft;
        }

        // 返回最终的层序遍历结果
        return ans;
    }

}
