package easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class T933最近的请求次数 {
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
    /*
        在类的构造函数中，使用ArrayDeque创建了一个队列（queue）来存储时间戳。

        ping方法接收一个时间戳（t），并返回过去3000毫秒内的请求数量。

        在ping方法中，首先将传入的时间戳加入队列。

        然后，使用一个循环，不断检查队首的时间戳是否小于当前时间戳减去3000。如果是，则表示该时间戳已经不在过去3000毫秒内，需要将其从队列中移除，直到队首的时间戳大于等于当前时间戳减去3000。

        最后，返回队列的大小，即过去3000毫秒内的请求数量。

        时间复杂度：均摊 O(1)，每个元素至多入队出队各一次。
        空间复杂度：O(L)，其中 L 为队列的最大元素个数。
     */
    static class RecentCounter {
        Queue<Integer> queue; // 使用队列存储时间戳

        public RecentCounter() {
            queue = new ArrayDeque<Integer>(); // 初始化队列
        }

        public int ping(int t) {
            queue.offer(t); // 将当前时间戳加入队列
            while (queue.peek() < t - 3000) { // 当队首时间戳小于当前时间戳减去3000时
                queue.poll(); // 移除队首元素（时间戳）
            }
            return queue.size(); // 返回队列的大小，即当前时间戳在过去3000毫秒内的请求数量
        }
    }

}
