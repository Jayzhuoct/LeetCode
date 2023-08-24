package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T2160拆分数位后四位数字的最小和 {
    public static void main(String[] args) {
        System.out.println(minimumSum2(2932));
    }

    /*
        时间复杂度O(nlogn)
        空间复杂度O(n)
     */
    public static int minimumSum1(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.sort(list);
        return 10 * (list.get(0) + list.get(1)) + list.get(2) + list.get(3);
    }

    /*
        时间复杂度O(n)
        空间复杂度O(1)
     */
    public static int minimumSum2(int num) {
        int minSum = Integer.MAX_VALUE;     // 最小值
        int secondMin = Integer.MAX_VALUE;  // 第二小的值
        int thirdMin = Integer.MAX_VALUE;   // 第三小的值
        int fourthMin = Integer.MAX_VALUE;  // 第四小的值

        while (num != 0) {
            int digit = num % 10;  // 获取当前位的数字

            // 更新最小的四个数字
            if (digit < minSum) {
                fourthMin = thirdMin;
                thirdMin = secondMin;
                secondMin = minSum;
                minSum = digit;
            } else if (digit < secondMin) {
                fourthMin = thirdMin;
                thirdMin = secondMin;
                secondMin = digit;
            } else if (digit < thirdMin) {
                fourthMin = thirdMin;
                thirdMin = digit;
            } else if (digit < fourthMin) {
                fourthMin = digit;
            }

            num /= 10;  // 将数字缩小10倍，去掉最低位
        }

        return 10 * (minSum + secondMin) + thirdMin + fourthMin;  // 返回最小的四个数字之和
    }
}
