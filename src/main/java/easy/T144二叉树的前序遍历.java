package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T144二叉树的前序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);  // 创建二叉树
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        System.out.println(preorderTraversal(root));  // 前序遍历
    }

    /*
    递归
    时间复杂度O(n)，空间复杂度O(n)
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();  // 创建一个整数列表用于存储前序遍历结果
        preorderHelper(root, result);  // 调用辅助方法进行前序遍历
        return result;  // 返回前序遍历结果
    }

    public static void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;  // 递归终止条件：节点为空
        }
        result.add(root.val);  // 将当前节点的值添加到结果列表中
        preorderHelper(root.left, result);  // 先遍历左子树
        preorderHelper(root.right, result);  // 再遍历右子树
    }

    /*
    迭代

    初始时，将根节点入栈，然后进入循环。在循环中，首先从栈中取出一个节点，将其值加入结果列表中。
    然后，依次将当前节点的右子节点、左子节点入栈，以便后续访问。
    这样可以保证在下一次循环时，会先访问左子树中的节点。
    当栈为空且当前节点为null时，遍历结束。最后，返回前序遍历的结果列表。

    时间复杂度O(n)，空间复杂度O(n)
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();  // 存储遍历结果的列表
        if (root == null) {
            return res;  // 如果根节点为空，直接返回空列表
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();  // 使用栈来辅助遍历
        TreeNode node = root;  // 当前节点初始化为根节点
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);  // 遍历当前节点，并将值加入结果列表
                stack.push(node);  // 将当前节点入栈
                node = node.left;  // 移动到当前节点的左子节点
            }
            node = stack.pop();  // 当前节点为空，出栈
            node = node.right;  // 移动到当前节点的右子节点
        }
        return res;  // 返回前序遍历结果列表
    }

    /*
    Morris遍历

    初始时，将p1指向根节点，p2为空。在循环中，首先检查p1的左子节点p2。
    如果p2不为空，则说明当前节点还有左子树未遍历完。
    在这种情况下，需要找到当前节点左子树的最右节点，即p2的右子节点。
    如果p2的右子节点为空或者指向p1，说明左子树未被遍历过，需要先遍历左子树。
    这时，将当前节点的值加入结果列表，并将p2的右子节点指向p1，然后将p1指向其左子节点，继续遍历左子树。
    如果p2的右子节点不为空且不指向p1，说明左子树已经被遍历过，需要将p2的右子节点置为空，然后继续遍历右子树。
    如果p2为空，说明当前节点没有左子树，直接将当前节点的值加入结果列表。
    最后，将p1指向其右子节点，继续遍历右子树。当p1为null时，遍历结束。最后，返回前序遍历的结果列表。

    时间复杂度O(n)，空间复杂度O(1)
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();  // 存储遍历结果的列表
        if (root == null) {
            return res;  // 如果根节点为空，直接返回空列表
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);  // 遍历当前节点，并将值加入结果列表
                    p2.right = p1;
                    p1 = p1.left;
                    continue;  // 继续遍历当前节点的左子树
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);  // 遍历当前节点，并将值加入结果列表
            }
            p1 = p1.right;  // 移动到当前节点的右子节点
        }
        return res;  // 返回前序遍历结果列表
    }

}
