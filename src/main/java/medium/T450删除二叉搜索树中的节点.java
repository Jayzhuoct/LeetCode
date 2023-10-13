package medium;

import common.TreeNode;

public class T450删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        root.printTreeToNums(deleteNode(root, 3));
    }

    /*
        递归
        首先，代码检查根节点是否为空，如果为空，则直接返回null。
        接下来，代码检查根节点的值是否等于key。如果是，那么有以下几种情况：

        如果根节点的左子树为空，则直接将右子树作为新的根节点返回。
        如果根节点的右子树为空，则直接将左子树作为新的根节点返回。
        如果根节点的左右子树都不为空，代码会找到右子树中的最左子节点（即右子树中最小的节点），将其值赋给根节点，然后递归地删除右子树中的该节点。
        如果根节点的值小于key，则递归地在右子树中删除key。

        如果根节点的值大于key，则递归地在左子树中删除key。

        最后，代码返回删除节点后的树的根节点。

        getMin方法用于获取给定节点右子树中的最左子节点，即右子树中的最小节点。
        它通过遍历右子树的左子节点，直到找到最左子节点为止，并返回该节点。

        时间复杂度：O(logn)，其中 n 是二叉搜索树的节点数。删除一个节点的时间复杂度取决于从根节点到被删除节点的路径的长度，而路径的长度最大为 n−1，因此时间复杂度为 O(logn)。
        空间复杂度：O(n）。空间复杂度主要取决于递归调用的栈空间，而栈空间在二叉搜索树中最多不会超过 n 层。
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        // 如果根节点为空，直接返回null
        if (root == null) {
            return null;
        }

        // 如果根节点的值等于key
        if (root.val == key) {
            // 如果根节点的左子树为空，则直接返回右子树
            if (root.left == null) {
                return root.right;
            }

            // 如果根节点的右子树为空，则直接返回左子树
            if (root.right == null) {
                return root.left;
            }

            // 如果根节点的左右子树都不为空
            if (root.left != null && root.right != null) {
                // 将根节点的右子树的最左子节点的值赋给根节点
                root.val = getMin(root.right).val;
                // 删除根节点的右子树的最左子节点
                root.right = deleteNode(root.right, root.val);
            }
        }

        // 如果根节点的值小于key，则递归删除右子树中的key
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        // 如果根节点的值大于key，则递归删除左子树中的key
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private static TreeNode getMin(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
