package easy;

public class T917仅仅反转字母 {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }

    // 时间复杂度：O(n)，其中 n 是字符串的长度。需要遍历每个字符一次。
    // 空间复杂度：O(1)。只需要在常数空间内进行变量交换。
    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();  // 将字符串转换为字符数组，方便后续操作
        int left = 0;  // 左指针，从字符串的开头开始
        int right = arr.length - 1;  // 右指针，从字符串的末尾开始
        while (left < right) {  // 使用两个指针从两端向中间遍历
            if (!Character.isLetter(arr[left])) {  // 如果左指针指向的字符不是字母，则左指针右移
                left++;
            } else if (!Character.isLetter(arr[right])) {  // 如果右指针指向的字符不是字母，则右指针左移
                right--;
            } else {  // 如果左右指针指向的字符都是字母
                char temp = arr[left];  // 临时变量存储左指针指向的字符
                arr[left++] = arr[right];  // 将右指针指向的字符赋值给左指针位置，并将左指针右移
                arr[right--] = temp;  // 将临时变量中的字符赋值给右指针位置，并将右指针左移
            }
        }
        return new String(arr);  // 将字符数组转换为字符串并返回结果
    }
}
