package easy;

import common.ListNode;

public class T876链表的中间结点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode middleNode = middleNode(head);
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }


    }
    /*
    函数接受一个链表的头节点作为输入。

    创建两个指针，slow 和 fast，初始时它们都指向链表的头节点。

    fast 指针的移动速度是 slow 指针的两倍。这样，当 fast 指针到达链表末尾时，slow 指针正好指向链表的中间节点。

    while 循环会一直执行，直到 fast 指针到达链表的末尾。如果 fast.next 为 null，说明 fast 指针已经到达链表的最后一个节点，这意味着链表的节点数为奇数。

    在这种情况下，slow 指针指向的就是中间节点，所以将其作为结果返回。

    如果 fast.next 不为 null，说明 fast 指针已经到达链表的倒数第二个节点，这意味着链表的节点数为偶数。

    在这种情况下，slow 指针指向的是两个中间节点中的第一个节点，所以将其作为结果返回。

    如果输入的链表为空（head 为 null），那么 slow 指针也会为 null，这时将其作为结果返回。

    时间复杂度是O(n)，其中n是链表的长度。需要遍历整个链表，所以时间复杂度是线性的。
    空间复杂度是O(1)，只使用了两个指针，与链表中的节点数无关。
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;  // 慢指针，初始指向链表头节点
        ListNode fast = head;  // 快指针，初始指向链表头节点

        while (fast != null) {  // 当快指针没有达到链表末尾时循环
            if (fast.next == null) {  // 如果快指针的下一个节点为空，说明链表节点数为奇数
                return slow;  // 返回慢指针所在的节点，即中间节点
            }
            slow = slow.next;  // 慢指针向后移动一步
            fast = fast.next.next;  // 快指针向后移动两步
        }

        return slow;  // 返回慢指针所在的节点，即中间节点
    }

}
