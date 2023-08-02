package easy;

public class T83删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
    /*
    创建一个指针变量cur，初始值为head。
    进入while循环，循环条件是cur不为null，也就是遍历整个单链表。
    在循环内部，首先判断cur和cur.next是否为空，如果为空，说明链表中只有一个节点，直接返回head即可。
    如果不为空，就判断cur和cur.next的值是否相等，如果相等，就删除cur.next，也就是删除下一个节点。
    如果不相等，就后移cur，指向下一个节点。
    循环结束后，返回head，也就是删除重复节点后的单链表的头节点。
    时间复杂度：O(n)，其中 n 是链表的长度。
    空间复杂度：O(1)。
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 如果当前节点和下一个节点的值相等，就删除下一个节点
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                // 如果当前节点和下一个节点的值不相等，就后移当前节点
                cur = cur.next;
            }
        }
        return head;
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
