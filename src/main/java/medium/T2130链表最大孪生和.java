package medium;

import common.ListNode;

import java.util.Deque;

public class T2130链表最大孪生和 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,new ListNode(4)))); // 1 2 3 4

            int res = pairSum1(head);
            System.out.println(res);
    }

    /*
        快慢指针
        首先，使用快慢指针找到链表的中间节点。
        快指针每次移动两步，慢指针每次移动一步，当快指针到达链表末尾或倒数第二个节点时，慢指针指向的节点就是链表的中间节点。
        将链表分为两部分，一部分是从链表头节点到中间节点的偶数节点链表，另一部分是从中间节点的下一个节点到链表尾节点的奇数节点链表。
        反转奇数节点链表，将链表的指针方向改为从链表尾节点指向链表头节点。
        遍历偶数节点链表和反转后的奇数节点链表，计算两个节点值之和，并记录最大值。
        返回最大节点值和作为结果。
        时间复杂度：O(n)，其中 n 是链表的长度。
        空间复杂度：O(1)。

     */
    public static int pairSum1(ListNode head) {
        ListNode fast = head;  // 快指针，每次移动两步
        ListNode slow = head;  // 慢指针，每次移动一步

        // 快指针每次移动两步，慢指针每次移动一步，直到快指针到达链表末尾或倒数第二个节点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode oddListNode = slow.next;  // 奇数节点链表的头节点
        slow.next = null;  // 将原始链表分为两个部分，将奇数节点链表与偶数节点链表断开

        ListNode cur = oddListNode;  // 当前节点指针，用于反转奇数节点链表
        ListNode prev = null;  // 前一个节点指针，用于反转奇数节点链表
        // 反转奇数节点链表
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        int res = 0;  // 结果变量，记录最大的节点值和

        // 遍历偶数节点链表和反转后的奇数节点链表，计算节点值的和的最大值
        while (head != null) {
            res = Math.max(prev.val + head.val, res);
            head = head.next;
            prev = prev.next;
        }

        return res;  // 返回最大节点值和
    }


    /*
        双端队列
        1. 创建一个双端队列（使用Java中的LinkedList实现）。
        2. 使用一个指针cur遍历链表，将链表中的所有节点按顺序添加到双端队列的末尾。
        3. 初始化最大节点值和max为0。
        4. 在双端队列不为空的情况下，循环执行以下操作：
            从双端队列的头部取出一个节点，保存为temp。
            从双端队列的尾部取出一个节点，保存为temp2。
            计算temp`temp2节点值之和，并将其与max比较，更新max为较大值。
        5. 返回最大节点值和`max`作为结果。

        时间复杂度为O(N)，其中N是链表的长度。
        由于使用了双端队列来存储链表节点，额外空间复杂度也为O(N)，其中N是链表的长度。
     */
    public static int pairSum2(ListNode head) {
        Deque<ListNode> deque = new java.util.LinkedList<>();  // 创建一个双端队列

        ListNode cur = head;  // 当前节点指针，用于遍历链表
        while (cur != null) {
            deque.addLast(cur);  // 将当前节点添加到双端队列的末尾
            cur = cur.next;  // 移动到下一个节点
        }

        int max = 0;  // 最大节点值和

        while (!deque.isEmpty()) {
            ListNode temp = deque.pollFirst();  // 从双端队列的头部取出一个节点
            ListNode temp2 = deque.pollLast();  // 从双端队列的尾部取出一个节点
            max = Math.max(max, temp.val + temp2.val);  // 计算两个节点值之和，并更新最大值
        }

        return max;  // 返回最大节点值和
    }
}
