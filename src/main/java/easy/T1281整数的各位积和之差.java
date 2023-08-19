package easy;

public class T1281整数的各位积和之差 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    /*
        * 时间复杂度：O(logn)，其中 n 为目标数。每次循环都将 n 除以 10，直到 n 为 0，循环次数为数字 n 的位数。
        * 空间复杂度：O(1)。
     */
    public static int subtractProductAndSum(int n) {
        int m = 1; // 用于存储乘积的变量，初始值为1
        int s = 0; // 用于存储和的变量，初始值为0

        while (n != 0) { // 当n不等于0时循环执行以下操作
            int x = n % 10; // 取n的个位数
            n /= 10; // 将n除以10，去掉个位数
            m *= x; // 计算乘积，将乘积与当前个位数相乘
            s += x; // 计算和，将和与当前个位数相加
        }

        return m - s; // 返回乘积与和的差值
    }
}
