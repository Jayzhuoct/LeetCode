package medium;

import common.TreeNode;

import java.util.*;

public class T199二叉树的右视图 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null,
                new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(rightSideView1(root));
    }

    /*
        深度优先搜索
        思路：对于每一个深度，只保留一个节点。
        具体做法是，我们在遍历树的时候，总是先访问右子树。
        这样就保证了当我们访问树的某个特定深度时，我们正在访问的节点总是该深度的最右侧节点。
        由于我们在每个深度访问的节点只有一个，因此我们的策略总会访问每个深度最右的节点。
        此外，由于我们总是先访问右子树，因此当我们访问到某个深度的时候，一定是该深度最右边的节点在先。
        这就保证了我们在遍历完整棵树之后，每个深度都包含最右边的节点，因此可以正确地得到每个深度最右边的节点。
        时间复杂度：O(n)，其中 n 是树中节点的数量。每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为 O(n)。
        空间复杂度：O(n)，其中 n 是树中节点的数量。空间复杂度取决于队列开销，队列中的节点个数不会超过 n。
     */
    public static List<Integer> rightSideView1(TreeNode root) {
        // 创建一个映射表，用于记录每个深度对应的最右侧节点的值
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        // 初始化最大深度为-1
        int max_depth = -1;
        // 创建两个栈，一个用于存储节点，一个用于存储节点的深度
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        // 将根节点入栈，并将其深度设为0
        nodeStack.push(root);
        depthStack.push(0);
        // 遍历栈，直到栈为空
        while (!nodeStack.isEmpty()) {
            // 弹出栈顶的节点和对应的深度
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            // 如果节点不为空
            if (node != null) {
                // 更新最大深度
                max_depth = Math.max(max_depth, depth);
                // 如果当前深度在映射表中没有对应的值，则将该节点的值加入映射表
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                // 将当前节点的左右子节点入栈，并将它们的深度加1入栈
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        // 创建一个列表，用于存储右侧视图的节点值
        List<Integer> rightView = new ArrayList<>();
        // 根据最大深度遍历映射表，将每个深度对应的节点值加入列表
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        // 返回右侧视图的节点值列表
        return rightView;
    }

    /*
        广度优先搜索
        思路：我们对树进行广度优先搜索，当遍历树的时候，我们总是先访问右子树。
        由于每一层我们只取一个节点，因此得到的就是从右边看到的节点。
        时间复杂度：O(n)，其中 n 是树中节点的数量。每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为 O(n)。
        空间复杂度：O(n)，其中 n 是树中节点的数量。空间复杂度取决于队列开销，队列中的节点个数不会超过 n。
     */
    public static List<Integer> rightSideView2(TreeNode root) {
        // 创建一个映射表，用于记录每个深度对应的最右侧节点的值
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        // 初始化最大深度为-1
        int max_depth = -1;
        // 创建两个队列，一个用于存储节点，一个用于存储节点的深度
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        // 将根节点入队，并将其深度设为0
        nodeQueue.add(root);
        depthQueue.add(0);
        // 遍历队列，直到队列为空
        while (!nodeQueue.isEmpty()) {
            // 移除队列头部的节点和对应的深度
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();
            // 如果节点不为空
            if (node != null) {
                // 更新最大深度
                max_depth = Math.max(max_depth, depth);
                // 将当前深度与节点的值加入映射表
                rightmostValueAtDepth.put(depth, node.val);
                // 将当前节点的左右子节点入队，并将它们的深度加1入队
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        // 创建一个列表，用于存储右侧视图的节点值
        List<Integer> rightView = new ArrayList<>();
        // 根据最大深度遍历映射表，将每个深度对应的节点值加入列表
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        // 返回右侧视图的节点值列表
        return rightView;
    }
}
