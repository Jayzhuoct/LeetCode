package easy;

public class T2011执行操作后的变量值 {
    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperations(operations));
    }

    /*
        时间复杂度O(n)
        空间复杂度O(1)
     */
    public static int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.contains("++")) {
                ++ans;
            } else {
                --ans;
            }
        }
        return ans;
    }
}
