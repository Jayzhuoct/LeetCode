package easy;


public class T415字符串相加 {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings(num1,num2));
    }
    /*函数使用了双指针和进位的思想，从两个字符串的末尾开始同时遍历，逐位相加，并将进位传递到下一位。
    具体来说，函数首先创建一个 StringBuilder 对象 sb 用于存储相加后的结果。
    然后使用两个指针 i 和 j 分别指向 num1 和 num2 的末尾，同时还定义一个进位变量 carry，初始值为 0。
    接下来进入一个 while 循环，只要 i 或 j 中至少有一个大于等于 0，就一直执行循环体。
    在循环体中，首先取出 num1 和 num2 的当前位的数字，如果当前位超出了某个字符串的长度，则将对应的数字视为 0。
    然后将这两个数字和进位相加，得到一个临时的和 temp，并计算出新的进位。
    将 temp 的个位数加入到 sb 的末尾，并将 i 和 j 分别向前移动一位。
    最后，循环结束后，如果还有进位，则将它加入到 sb 的末尾。
    最后，将 sb 反转后转换成字符串并返回即可。
    其中，时间复杂度为 O(max(m,n))，其中 m 和 n 分别是 num1 和 num2 的长度。
    空间复杂度为 O(max(m,n))，因为需要使用一个 StringBuilder 对象来存储结果，其长度最多为 max(m,n) + 1。
    */
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1,j = num2.length()-1,add = 0;
        while (i >= 0 || j >= 0){
            //如果 i 大于等于 0，即字符串 num1 还有未处理的位，
            // 就返回 num1 当前位的数字，即将当前位的字符转换成数字后得到的整数，否则返回 0
            int n1 = i >= 0 ? num1.charAt(i)-'0' : 0;
            int n2 = j >= 0 ? num2.charAt(j)-'0' : 0;
            int temp = n1 + n2 + add;
            add = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;
        }
        if (add == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}

