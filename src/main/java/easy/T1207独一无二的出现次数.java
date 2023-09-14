package easy;

public class T1207独一无二的出现次数 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    /*
        时间复杂度为O(N)，其中N是数组 arr 的长度。代码中有三个循环，
        但它们的迭代次数都与数组长度N成比例，因此总体的时间复杂度是线性的。

        空间复杂度为O(1)，即常数级别的额外空间。代码中使用了两个大小为2001和1001的整型数组，
        它们的大小与输入规模无关，因此空间复杂度是常数级别的。
     */
    public static boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001]; // 创建一个数组用于统计每个元素出现的次数，索引范围是[-1000, 1000]
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++; // 将元素映射到数组的索引位置，并增加对应索引位置的计数器
        }
        int[] count2 = new int[1001]; // 创建一个数组用于统计每个出现次数的次数，索引范围是[0, 1000]
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                count2[count[i]]++; // 统计每个出现次数的次数
            }
        }
        for (int i = 0; i < count2.length; i++) {
            if (count2[i] > 1) {
                return false; // 如果某个出现次数大于1，则返回false
            }
        }
        return true; // 没有出现次数大于1的情况，返回true
    }
}
