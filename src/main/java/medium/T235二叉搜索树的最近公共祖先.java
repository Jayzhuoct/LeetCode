package medium;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class T235二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        // 测试用例
        // 构造二叉树
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        TreeNode p = node1;
        TreeNode q = node2;

        // 测试
        System.out.println(lowestCommonAncestor1(root, p, q).val);
    }


    /*
    * 方法一：两次遍历
    * 思路
    我们从根节点开始遍历；
    如果当前节点就是 p，那么成功地找到了节点；
    如果当前节点的值大于 p 的值，说明 p 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
    如果当前节点的值小于 p 的值，说明 p 应该在当前节点的右子树，因此将当前节点移动到它的右子节点。
    对于节点 q 同理。在寻找节点的过程中，我们可以顺便记录经过的节点，这样就得到了从根节点到被寻找节点的路径。
    当我们分别得到了从根节点到 p 和 q 的路径之后，我们就可以很方便地找到它们的最近公共祖先了。
    显然，p 和 q 的最近公共祖先就是从根节点到它们路径上的「分岔点」，也就是最后一个相同的节点。
    因此，如果我们设从根节点到 p 的路径为数组 path_p，从根节点到 q 的路径为数组 path_q，那么只要找出最大的编号 i，其满足
    path_p[i]=path_q[i]
    那么对应的节点就是「分岔点」，即 p 和 q 的最近公共祖先就是 path_p[i]（或 path_q[i]）。
    * 时间复杂度：O(n)，其中 n 是给定的二叉搜索树中的节点个数。
    * 空间复杂度：O(n)。
    */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 获取节点 p 和节点 q 的路径
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        // 遍历路径，找到最近的公共祖先节点
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        // 从根节点开始遍历，直到找到目标节点
        while (node != target) {
            path.add(node);
            // 根据目标节点的值与当前节点的值的比较结果，决定向左子树还是右子树遍历
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    /*
    * 方法二：一次遍历
    我们从根节点开始遍历；
    如果当前节点的值大于 ppp 和 qqq 的值，说明 ppp 和 qqq 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
    如果当前节点的值小于 ppp 和 qqq 的值，说明 ppp 和 qqq 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
    如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，ppp 和 qqq 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
    */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    /*
    * 方法三：递归
    在每一次递归调用中，根据根节点的值与目标节点的值的比较结果，决定向左子树还是右子树递归搜索。
    * 如果根节点的值小于 p 和 q 的值，说明 p 和 q 分别位于根节点的右子树中，递归搜索右子树。
    * 如果根节点的值大于 p 和 q 的值，说明 p 和 q 分别位于根节点的左子树中，递归搜索左子树。
    * 如果不满足以上两种情况，即根节点的值介于 p 和 q 的值之间或者等于其中之一的值，那么根节点就是最近的公共祖先节点，返回根节点即可。
    * 时间复杂度：O(n)，其中 n 是给定的二叉搜索树中的节点个数。
    * 空间复杂度：O(n)。
     */
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点的值小于 p 和 q 的值，说明 p 和 q 分别位于根节点的右子树中，递归搜索右子树
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor3(root.right, p, q);
        }
        // 如果根节点的值大于 p 和 q 的值，说明 p 和 q 分别位于根节点的左子树中，递归搜索左子树
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor3(root.left, p, q);
        }
        // 否则，根节点即为最近的公共祖先节点
        return root;
    }
}
