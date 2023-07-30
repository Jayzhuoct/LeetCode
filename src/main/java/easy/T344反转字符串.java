package easy;

public class T344反转字符串 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
    /*函数使用了双指针的思想，从数组的两端开始同时遍历，逐个交换两端的字符，直到中间位置。

    具体来说，函数首先使用两个指针 left 和 right 分别指向字符数组的开头和结尾。
    接下来进入一个 while 循环，只要 left 小于 right，就一直执行循环体。

    在循环体中，首先将 s[left] 和 s[right] 交换位置，然后将 left 向后移动一位，将 right 向前移动一位。
    最后，循环结束后，原数组中的字符顺序已经被反转。

    其中，时间复杂度为 O(n)，其中 n 是字符数组的长度。空间复杂度为 O(1)，因为只使用了常数个额外变量。*/
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
