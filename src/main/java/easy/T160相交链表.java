package easy;

import common.ListNode;

public class T160相交链表 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        headA.next = node1;
        node1.next = node8;
        node8.next = node4;
        node4.next = node5;

        ListNode headB = new ListNode(5);
        ListNode node0 = new ListNode(0);
        ListNode node1_ = new ListNode(1);
        headB.next = node0;
        node0.next = node1_;
        node1_.next = node8;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    /*
        双指针
        假设链表A和链表B相交于节点C，且在相交之前的部分长度分别为lenA和lenB，在相交之后的部分长度为lenC。
        则指针nodeA和nodeB分别从链表A和链表B的头部开始遍历，当遍历到链表末尾时，将其指向另一个链表的头部，继续遍历。
        如果链表A和链表B相交，则在第lenA + lenB + lenC次遍历时，nodeA和nodeB会相等，此时返回相交节点C。
        如果链表A和链表B不相交，则在遍历完两个链表的长度之后，nodeA和nodeB都会变为null，此时返回null。

        时间复杂度：O(lenA + lenB)
        空间复杂度：O(1)
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;  // 如果nodeA到达了链表末尾，则将其指向headB，继续遍历
            nodeB = nodeB == null ? headA : nodeB.next;  // 如果nodeB到达了链表末尾，则将其指向headA，继续遍历
        }
        return nodeA;  // 返回相交节点或者null（如果链表不相交）
    }


}
