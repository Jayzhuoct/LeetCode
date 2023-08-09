package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);  // 创建二叉树
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        System.out.println(inorderTraversal2(root));  // 中序遍历
    }

    /*
    递归
    首先创建一个空列表result用于存储中序遍历结果。
    定义了一个辅助方法inorderHelper，它接受一个节点node和结果列表result作为参数。在该辅助方法中，首先检查节点是否为空，如果为空则直接返回。
    然后，递归调用inorderHelper方法遍历左子树，将左子树的中序遍历结果添加到结果列表中。
    接下来，将当前节点的值node.val添加到结果列表中。
    最后，递归调用inorderHelper方法遍历右子树，将右子树的中序遍历结果添加到结果列表中。
    在inorderTraversal方法中，首先创建一个空的结果列表result，然后调用inorderHelper方法进行中序遍历，最后返回结果列表。
    时间复杂度：O(n)，其中n是二叉树的节点数。二叉树的每个节点最多被访问一次。
    空间复杂度：O(n)，其中n是二叉树的节点数。空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过n。
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();  // 创建一个整数列表用于存储中序遍历结果
        inorderHelper(root, result);  // 调用辅助方法进行中序遍历
        return result;  // 返回中序遍历结果
    }

    public static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;  // 递归终止条件：节点为空
        }
        inorderHelper(node.left, result);  // 先遍历左子树
        result.add(node.val);  // 将当前节点的值添加到结果列表中
        inorderHelper(node.right, result);  // 再遍历右子树
    }

    /*
    迭代
    首先创建一个空的结果列表result和一个栈stack，用于辅助迭代过程。
    将当前节点curr初始化为根节点root。
    在迭代过程中，首先将当前节点及其左子节点依次入栈，直到当前节点为空。然后，从栈中弹出一个节点，将其值添加到结果列表中，并将当前节点指向弹出节点的右子节点。
    重复上述步骤，直到当前节点为空且栈为空。最后，返回结果列表。
    时间复杂度：O(n)，其中n是二叉树的节点数。二叉树的每个节点最多被访问一次。
    空间复杂度：O(n)，其中n是二叉树的节点数。空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过n。
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();  // 创建一个整数列表用于存储中序遍历结果
        Stack<TreeNode> stack = new Stack<>();  // 创建一个栈用于辅助迭代过程
        TreeNode curr = root;  // 当前节点
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);  // 将当前节点入栈
                curr = curr.left;  // 移动到左子节点
            }
            curr = stack.pop();  // 弹出栈顶节点
            result.add(curr.val);  // 将节点值添加到结果列表中
            curr = curr.right;  // 移动到右子节点
        }
        return result;  // 返回中序遍历结果
    }

    /*
    Morris中序遍历
    首先创建一个空的结果列表result，并将当前节点curr初始化为根节点root。
    在迭代过程中，首先判断当前节点curr的左子节点是否为空。如果为空，将当前节点的值添加到结果列表中，并将当前节点指向其右子节点。
    如果当前节点的左子节点不为空，找到当前节点的左子树中的最右节点，即当前节点的左子树的最右下角节点，通常称为前驱节点。
    判断前驱节点的右指针是否为空。如果为空，说明当前节点尚未线索化，将前驱节点的右指针指向当前节点，并将当前节点移动到其左子节点。
    如果前驱节点的右指针不为空，说明当前节点已经线索化，将前驱节点的右指针恢复为空，将当前节点的值添加到结果列表中，并将当前节点指向其右子节点。
    重复上述步骤，直到当前节点为空。最后，返回结果列表。
    Morris中序遍历利用了二叉树中大量空指针的特性，通过线索化建立节点之间的连接关系，实现了中序遍历的过程。
    相比于使用栈的迭代方法，Morris中序遍历的空间复杂度为O(1)。
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();  // 创建一个整数列表用于存储中序遍历结果
        TreeNode curr = root;  // 当前节点
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);  // 将节点值添加到结果列表中
                curr = curr.right;  // 移动到右子节点
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    result.add(curr.val);  // 将节点值添加到结果列表中
                    curr = curr.right;  // 移动到右子节点
                }
            }
        }
        return result;  // 返回中序遍历结果
    }
}
