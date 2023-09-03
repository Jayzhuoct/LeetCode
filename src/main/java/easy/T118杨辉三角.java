package easy;

import java.util.ArrayList;
import java.util.List;

public class T118杨辉三角 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);
        for (List<Integer> row : res) {
            System.out.println(row);
        }
    }

    /*
        时间复杂度：O(numRows^2)，其中 numRows 是杨辉三角的行数。
        空间复杂度：O(numRows^2)。我们需要一个 numRows*numRows 的二维数组存放杨辉三角的信息。
        不考虑返回值的空间占用，则空间复杂度为 O(1)。
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {// 行
            List<Integer> row = new ArrayList<>();// 每一行的元素
            for (int j = 0; j <= i; ++j) {// 列
                if (j == 0 || j == i) {// 每一行的第一个元素和最后一个元素都是 1
                    row.add(1);// 第 i 行有 i+1 个元素
                } else {// 其他元素是上一行的左上角和右上角元素之和
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
