package medium;

public class T274H指数 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};  // 3
        int[] citations2 = {1, 3, 1};  // 1
        System.out.println(hIndex(citations));
        System.out.println(hIndex(citations2));
    }

    /*
        时间复杂度：O(n)，其中 n 是数组的长度。
        空间复杂度：O(n)。
     */
    public static int hIndex(int[] citations) {
        int n = citations.length;//论文总数
        int[] papers = new int[n + 1];//论文数为下标，引用数为值
        // 计数
        for (int c : citations) {//遍历引用数
            papers[Math.min(n, c)]++;//引用数大于论文数的，都算在最后一个论文数里
        }
        // 找出最大的 k
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {//从最后一个论文数开始，往前遍历
            k--;//论文数
        }
        return k;
    }
}
