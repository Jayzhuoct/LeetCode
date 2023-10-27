package medium;

public class T134加油站 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}; // 加油站汽油量
        int[] cost = {3, 4, 5, 1, 2}; // 加油站花费
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /*
        一次遍历+贪心算法
        时间复杂度 O(n),n为数组长度
        空间复杂度 O(1)
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0; // 总汽油量
        int currentGas = 0; // 当前累积汽油量
        int start = 0; // 起始位置

        for (int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                // 如果当前累积汽油量为负，则无法从当前位置出发，将起始位置设为下一个加油站
                start = i + 1;
                currentGas = 0;
            }
        }

        if (totalGas < 0) {
            // 如果总汽油量为负，则无法完成一次循环
            return -1;
        }

        return start;
    }
}
