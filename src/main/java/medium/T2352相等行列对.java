package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2352相等行列对 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(equalPairs1(grid));
        System.out.println(equalPairs2(grid));
    }

    /*
    * 暴力法
    * 1. 初始化结果变量 res 为 0，获取矩阵的大小 n
    * 2. 遍历行
    * 2.1 遍历列
    * 2.1.1 调用 equal 方法判断当前点是否与所在行和列的元素相等
    * 时间复杂度：O(n^3)，其中 n 是矩阵的大小。
    * 空间复杂度：O(1)。
     */
    public static int equalPairs1(int[][] grid) {
        int res = 0, n = grid.length;  // 初始化结果变量 res 为 0，获取矩阵的大小 n
        for (int row = 0; row < n; row++) {  // 遍历行
            for (int col = 0; col < n; col++) {  // 遍历列
                if (equal(row, col, n, grid)) {  // 调用 equal 方法判断当前点是否与所在行和列的元素相等
                    res++;  // 如果相等，将结果 res 加一
                }
            }
        }
        return res;  // 返回结果 res
    }

    public static boolean equal(int row, int col, int n, int[][] grid) {
        for (int i = 0; i < n; i++) {  // 遍历行和列
            if (grid[row][i] != grid[i][col]) {  // 如果当前点所在行的元素与当前点所在列的元素不相等
                return false;  // 返回 false
            }
        }
        return true;  // 如果所有行和列的元素都相等，返回 true
    }

    /*
    * 哈希表
    * 1. 初始化结果变量 res 为 0，获取矩阵的大小 n
    * 2. 创建一个存储列表和出现次数的映射关系的哈希表 cnt
    * 3. 统计每一行的列表出现的次数
    * 3.1 遍历二维数组的每一行
    * 3.1.1 创建一个空的整数列表 arr
    * 3.1.2 遍历当前行的每个元素
    * 时间复杂度：O(n^2)，其中 n 是矩阵的大小。
    * 空间复杂度：O(n^2)，其中 n 是矩阵的大小。
     */
    public static int equalPairs2(int[][] grid) {
        int n = grid.length;  // 获取矩阵的大小 n
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();  // 创建一个存储列表和出现次数的映射关系的哈希表 cnt

        // 统计每一行的列表出现的次数
        for (int[] row : grid) {  // 遍历二维数组的每一行
            List<Integer> arr = new ArrayList<Integer>();  // 创建一个空的整数列表 arr
            for (int num : row) {  // 遍历当前行的每个元素
                arr.add(num);  // 将元素添加到列表 arr 中
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);  // 将列表 arr 作为键，获取其对应的次数并加一，然后更新到哈希表 cnt 中
        }

        int res = 0;  // 初始化结果变量 res 为 0

        // 检查每一列的列表是否存在于哈希表 cnt 中，并累加出现的次数到结果变量 res
        for (int j = 0; j < n; j++) {  // 遍历二维数组的每一列
            List<Integer> arr = new ArrayList<Integer>();  // 创建一个空的整数列表 arr
            for (int i = 0; i < n; i++) {  // 遍历当前列的每个元素
                arr.add(grid[i][j]);  // 将元素添加到列表 arr 中
            }
            if (cnt.containsKey(arr)) {  // 如果哈希表 cnt 中存在列表 arr
                res += cnt.get(arr);  // 将列表 arr 对应的次数累加到结果变量 res
            }
        }

        return res;  // 返回结果 res
    }
}
