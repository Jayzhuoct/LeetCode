package medium;

import common.ListNode;

public class T2两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    /*
        时间复杂度：O(max(m,n))
        空间复杂度：O(max(m,n))
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个哑节点，用于返回结果
        ListNode dummy = new ListNode(0);
        // 定义一个指针，指向哑节点
        ListNode cur = dummy;
        // 定义一个变量，用于记录进位
        int carry = 0;
        // 遍历两个链表
        while (l1 != null || l2 != null) {
            // 定义两个变量，用于记录当前节点的值
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 计算当前节点的值
            int sum = x + y + carry;
            // 计算进位
            carry = sum / 10;
            // 计算当前节点的值
            sum = sum % 10;
            // 创建一个新节点，保存当前节点的值
            cur.next = new ListNode(sum);
            // 将指针指向下一个节点
            cur = cur.next;
            // 如果l1不为空，将l1指向下一个节点
            if (l1 != null) l1 = l1.next;
            // 如果l2不为空，将l2指向下一个节点
            if (l2 != null) l2 = l2.next;
        }
        // 如果进位不为0，创建一个新节点，保存进位
        if (carry != 0) cur.next = new ListNode(carry);
        // 返回哑节点的下一个节点
        return dummy.next;
    }
}
