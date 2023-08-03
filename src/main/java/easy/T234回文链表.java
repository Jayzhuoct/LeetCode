package easy;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class T234回文链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome3(head));
    }

    //复制链表到数组中，然后双指针法
    /**
     * 判断链表是否为回文
     * @param head 链表头节点
     * @return 如果链表为回文则返回true，否则返回false
     时间复杂度是O(n)，其中n是链表的长度。需要遍历链表一次，将链表中的元素复制到数组中，再使用双指针法判断是否为回文，时间复杂度是O(n)。
     空间复杂度是O(n)，其中n是链表的长度。需要创建一个数组，空间复杂度是O(n)。
     */
    public static boolean isPalindrome1(ListNode head) {
        // 创建一个List，用于存储链表中的所有元素
        List<Integer> list = new ArrayList<>();
        // 遍历链表，将所有元素加入到List中
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        // 使用双指针的方式依次比较List中的左右两端是否相等
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        // 如果到达List的中间位置，说明链表为回文
        return true;
    }

    //递归
    // 定义一个静态成员变量frontPointer，用于记录链表的左端点
    static ListNode frontPointer;

    /**
     * 判断链表是否为回文
     * @param head 链表头节点
     * @return 如果链表为回文则返回true，否则返回false
     时间复杂度是O(n)
     空间复杂度是O(1)
     */
    static boolean isPalindrome2(ListNode head) {
        // 将头节点赋值给frontPointer
        frontPointer = head;
        // 调用递归函数
        return recursivelyCheck(head);
    }

    /**
     * 递归函数，用于依次比较链表的左右两端是否相等
     * @param currentNode 当前节点
     * @return 如果链表为回文则返回true，否则返回false
     */
    static boolean recursivelyCheck(ListNode currentNode) {
        // 递归终止条件：当前节点为null
        if (currentNode != null) {
            // 递归调用下一个节点
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            // 检查链表左右两端是否相等
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            // 将frontPointer指向下一个节点
            frontPointer = frontPointer.next;
        }
        // 如果到达链表的末尾，说明链表为回文
        return true;
    }

    //快慢指针
    /*
    1.找到链表的中间节点，同时反转链表的后半部分，得到反转后的链表的头节点。
    2.使用两个指针分别从链表的头部和反转后的链表的头部开始遍历，比较每个节点的值是否相等，如果有一个不相等，则说明链表不是回文。
    3.还原链表的后半部分，返回判断结果。
    */
    /**
     * 判断链表是否为回文
     * @param head 链表头节点
     * @return 如果链表为回文则返回true，否则返回false
    时间复杂度为O(n)，空间复杂度为O(1)
     */
    public static boolean isPalindrome3(ListNode head) {
        // 特判：如果链表为空，则认为它是回文的
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * 反转链表
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 找到链表的中间节点
     * @param head 链表头节点
     * @return 前半部分链表的尾节点
     */
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 快慢指针遍历链表，当快指针走到链表末尾时，慢指针刚好走到链表的中间位置
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
