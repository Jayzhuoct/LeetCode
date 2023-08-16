package medium;

public class T11盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    /*
        * 双指针法
        * 时间复杂度：O(n)
        * 空间复杂度：O(1)
        * 思路：
        *  1. 定义两个指针，分别指向数组的左右两端
        *  2. 计算当前左右指针所围成的区域面积
        *  3. 更新最大面积
        *  4. 移动指针
        *  5. 重复 2-4 步骤，直到左右指针相遇
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 计算当前左右指针所围成的区域面积
            int area = (right - left) * Math.min(height[left], height[right]);
            // 更新最大面积
            max = Math.max(max, area);
            // 移动指针
            if (height[left] < height[right]) {
                left++; // 向右移动左指针
            } else {
                right--; // 向左移动右指针
            }
        }
        return max;
    }

    //优化
    public static int maxArea2(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 计算当前左右指针所围成的区域面积
            int area = (right - left) * Math.min(height[left], height[right]);
            // 更新最大面积
            max = Math.max(max, area);
            // 找到比当前最小高度更高的木板
            int minH = Math.min(height[left], height[right]);
            // 移动指针直到找到比当前最小高度更高的木板
            while (left < right && height[left] <= minH) {
                left++; // 向右移动左指针
            }
            while (left < right && height[right] <= minH) {
                right--; // 向左移动右指针
            }
        }
        return max;
    }
}
