package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class T901股票价格跨度 {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        int param_1 = obj.next(100);
        int param_2 = obj.next(80);
        int param_3 = obj.next(60);
        int param_4 = obj.next(70);
        int param_5 = obj.next(60);
        int param_6 = obj.next(75);
        int param_7 = obj.next(85);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
        System.out.println(param_7);
    }

    /*
        时间复杂度：O(N)，其中 N 是股票价格的数量。
        对于每个价格，最多有一次对应的 NN 次单调递减的价格被推入栈中，对应着 O(N) 的时间复杂度。

        空间复杂度：O(N)，其中 N 是股票价格的数量。
     */
    static class StockSpanner {
        Deque<int[]> stack; // 使用双端队列保存股票价格的索引和对应的价格
        int idx; // 当前价格的索引

        public StockSpanner() {
            stack = new ArrayDeque<int[]>(); // 初始化双端队列
            stack.push(new int[]{-1, Integer.MAX_VALUE}); // 在队列中先放入一个辅助元素，表示初始状态
            idx = -1; // 初始化索引为-1
        }

        /**
         * 计算下一个股票价格的跨度
         * @param price 下一个股票价格
         * @return 跨度值
         */
        public int next(int price) {
            idx++; // 更新索引

            // 将小于等于当前价格的元素从队列中弹出，因为它们的跨度已经确定
            while (price >= stack.peek()[1]) {
                stack.pop();
            }

            // 计算跨度
            int ret = idx - stack.peek()[0];

            // 将当前价格和索引放入队列
            stack.push(new int[]{idx, price});

            return ret; // 返回跨度值
        }
    }

}
