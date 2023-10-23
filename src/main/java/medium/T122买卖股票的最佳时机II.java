package medium;

public class T122买卖股票的最佳时机II {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6};
        System.out.println(maxProfit(prices));
    }

    /*
        时间复杂度O(n)，n为价格数组的长度
        空间复杂度O(1)
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;  // 最大利润，初始化为0
        int buy = prices[0];  // 购买价格，初始化为第一个价格
        int sell = prices[0];  // 卖出价格，初始化为第一个价格

        for (int i = 1; i < prices.length; i++) {  // 遍历价格数组，从第二个价格开始
            if (prices[i] > sell) {  // 如果当前价格大于卖出价格
                sell = prices[i];  // 更新卖出价格为当前价格
            } else {  // 如果当前价格小于等于卖出价格
                maxProfit += sell - buy;  // 将卖出价格减去购买价格的差累加到最大利润中
                buy = prices[i];  // 更新购买价格为当前价格
                sell = prices[i];  // 更新卖出价格为当前价格
            }
        }

        maxProfit += sell - buy;  // 将最后一次交易的利润累加到最大利润中
        return maxProfit;  // 返回最大利润
    }
}
