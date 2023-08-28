package easy;

import common.TreeNode;

public class T108将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};// [-10,-3,0,5,9]
        TreeNode treeNode = sortedArrayToBST(nums);
        treeNode.printTreeToNums(treeNode);
    }

    // 时间复杂度：O(n)，其中 n 是数组的长度。每个数字只访问一次。
    // 空间复杂度：O(logn)，其中 n 是数组的长度。空间复杂度不考虑返回值，因此空间复杂度主要取决于递归调用的栈空间。
    public static TreeNode sortedArrayToBST(int[] nums) {
        // 递归
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int i, int i1) {
        if (i > i1) {
            return null;
        }
        int mid = (i + i1) / 2;// 取中间值
        TreeNode root = new TreeNode(nums[mid]);// 中间值作为根节点
        root.left = helper(nums, i, mid - 1);// 递归左子树
        root.right = helper(nums, mid + 1, i1);// 递归右子树
        return root;
    }
}
