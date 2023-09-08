package easy;

import java.util.ArrayList;
import java.util.List;

public class T1431拥有最多糖果的孩子 {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        System.out.println(kidsWithCandies(candies, 3));
    }

    /**
     * 判断每个孩子是否能够拥有最多糖果
     * @param candies 孩子们当前拥有的糖果数量数组
     * @param extraCandies 额外糖果的数量
     * @return 每个孩子是否能够拥有最多糖果的布尔值列表
     * 时间复杂度：O(n),其中 n 是糖果数量数组 candies 的长度。
     * 空间复杂度：O(n),其中 n 是糖果数量数组 candies 的长度。
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 创建一个布尔值列表，用于存储每个孩子是否能够拥有最多糖果
        List<Boolean> list = new ArrayList<>();

        // 找到当前糖果数量数组中的最大值
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        // 判断每个孩子是否能够拥有最多糖果，并将结果添加到布尔值列表中
        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }

        // 返回每个孩子是否能够拥有最多糖果的布尔值列表
        return list;
    }
}
