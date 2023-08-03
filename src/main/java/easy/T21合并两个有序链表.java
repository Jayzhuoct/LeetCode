package easy;

import common.ListNode;

public class T21合并两个有序链表 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);
        list1.next.next.next.next = new ListNode(9);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(10);
        ListNode res = mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
    /**
     * 合并两个有序单链表
     * @param list1 有序单链表1
     * @param list2 有序单链表2
     * @return 合并后的有序单链表
    时间复杂度是O(n)，其中n是两个有序单链表的总长度。因为代码只需要一次遍历就可以将两个有序单链表合并为一个有序单链表。

    空间复杂度是O(1)，因为除了头节点和指针变量cur以外，代码没有使用额外的空间，而这些变量的空间是常数级别的，与链表的长度无关。
    因此，空间复杂度是常量级别的，与链表的长度无关。
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个头节点，不存储任何值
        ListNode head = new ListNode();
        // 创建一个指针变量cur，初始值为head
        ListNode cur = head;
        // 循环遍历两个有序单链表，将小的节点接在cur的后面
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        // 将剩余的节点直接接在cur的后面
        cur.next = list1 == null ? list2 : list1;
        // 返回头节点的next指针，也就是合并后的有序单链表的头节点
        return head.next;
    }
}
