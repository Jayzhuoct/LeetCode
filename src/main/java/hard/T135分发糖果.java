package hard;

public class T135分发糖果 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    /*
        思路
        1. 定义一个数组，用于保存每个孩子分到的糖果数
        2. 将每个孩子分到的糖果数初始化为1
        3. 从左往右遍历，如果右边孩子的评分比左边孩子的评分高，右边孩子的糖果数等于左边孩子的糖果数加1
        4. 从右往左遍历，如果左边孩子的评分比右边孩子的评分高，左边孩子的糖果数等于右边孩子的糖果数加1
        5. 定义一个变量，用于保存总糖果数
        6. 遍历每个孩子分到的糖果数，将每个孩子分到的糖果数累加到sum中
        7. 返回总糖果数
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public static int candy(int[] ratings) {
        // 定义一个数组，用于保存每个孩子分到的糖果数
        int[] candies = new int[ratings.length];
        // 将每个孩子分到的糖果数初始化为1
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        // 从左往右遍历，如果右边孩子的评分比左边孩子的评分高，右边孩子的糖果数等于左边孩子的糖果数加1
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        // 从右往左遍历，如果左边孩子的评分比右边孩子的评分高，左边孩子的糖果数等于右边孩子的糖果数加1
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i],
                    candies[i + 1] + 1);
        }
        // 定义一个变量，用于保存总糖果数
        int sum = 0;
        // 遍历每个孩子分到的糖果数，将每个孩子分到的糖果数累加到sum中
        for (int candy : candies) {
            sum += candy;
        }
        // 返回总糖果数
        return sum;
    }
}
