package easy;

public class T121买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};  // 5
        System.out.println(maxProfit(prices));
    }

    /*
    一次遍历
    时间复杂度：O(n)
    空间复杂度：O(1)
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // 最低价格
        int maxProfit = 0;  // 最大利润

        for (int price : prices) {  // 遍历每个价格
            if (price < minPrice) {  // 如果当前价格小于最低价格
                minPrice = price;  // 更新最低价格
            } else if (price - minPrice > maxProfit) {  // 如果当前价格减去最低价格大于最大利润
                maxProfit = price - minPrice;  // 更新最大利润
            }
        }

        return maxProfit;  // 返回最大利润
    }
}
