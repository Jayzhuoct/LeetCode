package medium;

import common.ListNode;

public class T19删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode res = removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    /*
        双指针
        1. 创建一个虚拟节点作为头节点的前一个节点。
        2. 找到left的前一个节点。
        3. 从left开始反转。
        4. 返回反转后的链表头节点。
        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1); // 创建一个虚拟节点作为头节点的前一个节点
        dummy.next = head; // 将虚拟节点的下一个节点指向头节点
        ListNode fast = dummy; // 用fast指向当前节点
        ListNode slow = dummy; // 用slow指向当前节点
        // fast先向后移动n+1个节点
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        // fast和slow同时向后移动，直到fast指向null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除slow的下一个节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
