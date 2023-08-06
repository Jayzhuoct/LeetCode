package hard;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T297二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        // 创建一个二叉树进行测试
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // 序列化
        String serialized = serialize(root);
        System.out.println("Serialized tree: " + serialized);

        // 反序列化
        TreeNode deserialized = deserialize(serialized);

        // 验证反序列化后的二叉树
        System.out.println("Deserialized tree:");
        inorderTraversal(deserialized);
    }

    /**
     * 中序遍历二叉树（用于验证反序列化后的结果）
     * @param root 二叉树的根节点
     */
    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    //时间复杂度：O(N)，每个节点都访问一次
    //空间复杂度：O(N)，递归调用栈的深度最深为 N
    public static String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    /**
     * 序列化二叉树为字符串
     * @param root 当前节点
     * @param str  当前序列化的字符串
     * @return     序列化后的字符串
     */
    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,"; // 使用"None"表示空节点
        } else {
            str += str.valueOf(root.val) + ","; // 将节点值转为字符串并添加到序列化字符串中
            str = rserialize(root.left, str); // 递归序列化左子树
            str = rserialize(root.right, str); // 递归序列化右子树
        }
        return str;
    }

    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    /**
     * 反序列化字符串为二叉树
     * @param dataList 序列化字符串转为的字符串列表
     * @return         反序列化后的二叉树根节点
     */
    public static TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null; // 遇到"None"表示空节点，返回 null
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0))); // 创建当前节点
        dataList.remove(0);
        root.left = rdeserialize(dataList); // 递归反序列化左子树
        root.right = rdeserialize(dataList); // 递归反序列化右子树

        return root;
    }
}
