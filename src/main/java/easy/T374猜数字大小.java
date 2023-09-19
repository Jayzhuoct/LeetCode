package easy;

public class T374猜数字大小 {
    public static void main(String[] args) {
        int n = 100;
        int expected = 42;
        System.out.println(guessNumber(n) == expected);
    }

    /*
        二分查找
        思路：通过二分查找的方式在指定范围内猜数字。
        时间复杂度：O(logN)，其中N是给定数字范围内的数字个数。
        空间复杂度：O(1)，只使用了常数级别的额外空间。
     */
    public static int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
           return left;
    }

    private static int guess(int mid) {
        // 假设要猜测的数字为 target
        int target = 42;

        if (mid == target) {
            return 0; // 猜测的数字与目标数字相等
        } else if (mid < target) {
            return -1; // 猜测的数字比目标数字小
        } else {
            return 1; // 猜测的数字比目标数字大
        }
    }
}
