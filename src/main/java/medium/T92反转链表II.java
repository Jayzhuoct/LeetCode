package medium;

import common.ListNode;

public class T92反转链表II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode res = reverseBetween(head, 2, 4);
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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1); // 创建一个虚拟节点作为头节点的前一个节点
        dummy.next = head; // 将虚拟节点的下一个节点指向头节点
        ListNode pre = dummy; // 用pre指向当前节点的前一个节点
        // 找到left的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next; // pre向后移动，直到指向left的前一个节点
        }
        // 从left开始反转
        ListNode cur = pre.next; // cur指向当前节点
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next; // next指向当前节点的下一个节点
            cur.next = next.next; // 将当前节点指向next的下一个节点，即将当前节点从链表中移除
            next.next = pre.next; // 将next的下一个节点指向pre的下一个节点，即将next插入到pre的后面
            pre.next = next; // 将pre的下一个节点指向next，完成插入操作
        }
        return dummy.next; // 返回反转后的链表头节点
    }
}
