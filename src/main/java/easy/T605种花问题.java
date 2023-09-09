package easy;

public class T605种花问题 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }

    /*
        贪心算法：
        1、遍历花坛，如果当前位置已经种花，则跳过该位置；
        2、如果当前位置的前一个位置已经种花，则跳过该位置；
        3、如果当前位置的后一个位置已经种花，则跳过该位置；
        4、如果当前位置可以种花，则将计数器加 1，并将当前位置种花；
        5、判断计数器是否大于等于 n，如果是，则返回 true，否则返回 false。
        时间复杂度：O(n)，其中 n 是花坛的长度。
        空间复杂度：O(1)。
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 计数器，用于记录可以种花的数量
        int count = 0;
        // 遍历花坛
        for (int i = 0; i < flowerbed.length; i++) {
            // 如果当前位置已经种花，则跳过该位置
            if (flowerbed[i] == 1) {
                continue;
            }
            // 如果当前位置的前一个位置已经种花，则跳过该位置
            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }
            // 如果当前位置的后一个位置已经种花，则跳过该位置
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                continue;
            }
            // 如果当前位置可以种花，则将计数器加 1
            count++;
            // 将当前位置种花
            flowerbed[i] = 1;
        }
        // 判断计数器是否大于等于 n
        return count >= n;
    }
}
