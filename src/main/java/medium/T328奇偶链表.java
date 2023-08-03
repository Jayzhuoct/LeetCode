package medium;


public class T328奇偶链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode oddEvenList = oddEvenList(head);
        while (oddEvenList != null) {
            System.out.println(oddEvenList.val);
            oddEvenList = oddEvenList.next;
        }


    }

    //分离节点后合并
    //时间复杂度O(n)，空间复杂度O(1)
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;  // 奇数节点的头节点
        ListNode even = head.next;  // 偶数节点的头节点
        ListNode evenHead = even;  // 偶数节点的头节点，用于最后合并两个链表

        while (even != null && even.next != null) {  // 当偶数节点和偶数节点的下一个节点都不为空时循环
            odd.next = even.next;  // 奇数节点的下一个节点指向偶数节点的下一个节点
            odd = odd.next;  // 奇数节点向后移动一步
            even.next = odd.next;  // 偶数节点的下一个节点指向奇数节点的下一个节点
            even = even.next;  // 偶数节点向后移动一步
        }

        odd.next = evenHead;  // 奇数节点的下一个节点指向偶数节点的头节点，即将两个链表连接起来

        return head;  // 返回奇数节点的头节点，即整个链表的头节点

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

}
