package medium;

import common.ListNode;

public class T2095删除链表的中间节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(3,new ListNode(4,new ListNode(5))))); // 1 2 3 4 5

        ListNode res = deleteMiddle(head);

        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    /*
        快慢指针
        使用快慢指针，快指针每次移动两步，慢指针每次移动一步，当快指针到达链表末尾时，慢指针到达链表中间节点。
        时间复杂度：O(n)，其中 n 是链表的长度。
        空间复杂度：O(1)。
     */
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next.next; // 快指针，每次移动两步
        ListNode slow = head; // 慢指针，每次移动一步

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针移动两步
            slow = slow.next; // 慢指针移动一步
        }

        slow.next = slow.next.next; // 删除中间节点

        return head;
    }
}
