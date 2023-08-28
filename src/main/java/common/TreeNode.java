package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public void printTreeByLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.printf("%d ", node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(); // 换行输出下一层的节点
        }
    }

    public void printTreeToNums(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> nums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                nums.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                nums.add(null);
            }
        }

        // 移除末尾的连续 null 值
        while (!nums.isEmpty() && nums.get(nums.size() - 1) == null) {
            nums.remove(nums.size() - 1);
        }

        System.out.println(nums);
    }

}
