package medium;


import common.Node;

import java.util.HashMap;
import java.util.Map;

public class T138随机链表的复制 {
    public static void main(String[] args) {
        // 创建链表
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        // 设置next指针
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // 设置random指针
        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;
        // 复制链表
        Node headNew = copyRandomList2(head);
        // 打印链表
        for (Node node = headNew; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }

    }

    /*
        回溯 + 哈希表
        时间复杂度O(n)
        空间复杂度O(n)

     */
    // 创建一个缓存节点的映射，用于存储已经复制过的节点
    static Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    // 复制含有随机指针的链表
    public static Node copyRandomList1(Node head) {
        // 如果链表为空，返回null
        if (head == null) {
            return null;
        }

        // 如果缓存节点中不包含当前节点，进行复制操作
        if (!cachedNode.containsKey(head)) {
            // 创建一个与当前节点值相同的新节点
            Node headNew = new Node(head.val);

            // 将当前节点和对应的新节点放入缓存中
            cachedNode.put(head, headNew);

            // 递归复制下一个节点和随机指针指向的节点
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }

        // 返回当前节点对应的复制节点
        return cachedNode.get(head);
    }

    /*
        迭代 + 节点拆分
        时间复杂度O(n)
        空间复杂度O(1)
     */
    public static Node copyRandomList2(Node head) {
        // 如果链表为空，返回null
        if (head == null) {
            return null;
        }

        // 第一次遍历链表，将每个节点复制并插入到原节点的后面
        for (Node node = head; node != null; node = node.next.next) {
            // 创建一个与当前节点值相同的新节点
            Node nodeNew = new Node(node.val);

            // 将新节点插入到原节点的后面
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        // 第二次遍历链表，设置新节点的随机指针
        for (Node node = head; node != null; node = node.next.next) {
            // 获取当前节点对应的新节点
            Node nodeNew = node.next;

            // 设置新节点的随机指针
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }

        // 断开原节点和新节点的连接，恢复原链表的结构
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            // 获取当前节点对应的新节点
            Node nodeNew = node.next;

            // 断开原节点和新节点的连接
            node.next = node.next.next;

            // 恢复新节点之间的连接关系
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }

        // 返回新链表的头节点
        return headNew;
    }
}
