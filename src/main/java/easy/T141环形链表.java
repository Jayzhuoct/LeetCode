package easy;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class T141环形链表 {
    public static void main(String[] args) {
        // 创建一个包含环的单链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head; // 将最后一个节点的 next 指针指向第二个节点，形成环

        // 检测是否有环
        boolean hasCycle = hasCycle3(head);
        System.out.println(hasCycle); // 输出 true
        //没有环的单链表
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        boolean hasCycle1 = hasCycle3(head1);
        System.out.println(hasCycle1); // 输出 false

    }
    //1.哈希表法
    /*
    使用哈希表来存储所有已经访问过的节点。
    每次我们到达一个节点，如果该节点已经存在于哈希表中，则说明该链表是环形链表，
    否则就将该节点加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
    复杂度分析
    时间复杂度：O(N)其中N是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
    空间复杂度：O(N)其中N是链表中的节点数。
    主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次。
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //如果set中已经存在该节点，说明有环
            if (set.contains(head)) {
                return true;
            }
            //如果set中不存在该节点，将该节点加入set中
            set.add(head);
            //head指向下一个节点
            head = head.next;
        }
        return false;
    }
    //2.快慢指针法
    /*
    思路
    我们可以使用两个指针，一个指针slow每次只走一步，另一个指针fast每次走两步，
    如果链表中存在环，则两个指针必定在环上相遇。
    复杂度分析
    时间复杂度：O(N)其中N是链表中的节点数。在最初判断快慢指针是否相遇时，
    slow指针走过的距离不会超过链表的总长度；随后寻找入环点时，走过的距离也不会超过链表的总长度。
    因此，总的执行时间为O(N)+O(N)=O(N)。
    空间复杂度：O(1)我们只使用了两个指针的额外空间。
     */
    public static boolean hasCycle2(ListNode head) {
        //如果链表为空或者链表只有一个节点，返回false
        if (head == null || head.next == null) {
            return false;
        }
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        //当快指针不为空时
        while (fast != null) {
            //如果快慢指针相遇，说明有环
            if (fast == slow) {
                return true;
            }
            //快指针每次走两步
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            //慢指针每次走一步
            slow = slow.next;
        }
        return false;
    }

    //3.简单的快慢指针法
    public static boolean hasCycle3(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

}
