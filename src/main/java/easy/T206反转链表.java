package easy;

public class T206反转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /*
    创建三个指针变量：pre, cur, tmp。
    其中，pre指向前一个节点（初始值为null），cur指向当前节点（初始值为head），tmp用于保存下一个节点。
    进入while循环，循环条件是cur不为null，也就是遍历整个单链表。
    在循环内部，首先将tmp指向cur的下一个节点，即保存下一个节点的引用。
    接着，将cur的next指针指向pre，也就是将当前节点指向它的前一个节点，实现了翻转的功能。
    接下来，将pre后移，指向当前节点，也就是pre指向了刚才翻转后的当前节点。
    最后，将cur后移，指向tmp，也就是将当前节点移动到它原来的下一个节点。
    循环结束后，返回pre，也就是翻转后的单链表的头节点。

    时间复杂度是O(n)，其中n是链表的长度。这是因为代码通过while循环遍历了整个链表，每个节点都只被访问了一次，所以时间复杂度是线性的。

    空间复杂度是O(1)，因为除了三个指针变量pre、cur和tmp以外，没有使用额外的空间，而这些变量的空间是常数级别的，与链表的长度无关。
    因此，空间复杂度是常量级别的，与链表的长度无关。
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next; // 保存下一个节点
            cur.next = pre; // 当前节点指向前一个节点
            pre = cur; // 前一个节点后移
            cur = tmp; // 当前节点后移
        }
        return pre;
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
