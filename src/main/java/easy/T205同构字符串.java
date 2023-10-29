package easy;

public class T205同构字符串 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(isIsomorphic(s, t));
    }

    /*
        时间复杂度O(n)，空间复杂度O(1)
     */
    public static boolean isIsomorphic(String s, String t) {
        int[] arr1 = new int[128]; // 创建一个大小为128的整数数组，用于存储字符s的映射关系
        int[] arr2 = new int[128]; // 创建一个大小为128的整数数组，用于存储字符t的映射关系
        for (int i = 0; i < s.length(); i++) { // 遍历字符串s的每个字符
            char c1 = s.charAt(i); // 获取当前位置的字符c1
            char c2 = t.charAt(i); // 获取当前位置的字符c2

            if (arr1[c1] != arr2[c2]) { // 如果字符c1在数组arr1中对应的值与字符c2在数组arr2中对应的值不相等
                return false; // 则说明两个字符串不是同构的，返回false
            }
            arr1[c1] = i + 1; // 将字符c1在数组arr1中对应的值设为i+1
            arr2[c2] = i + 1; // 将字符c2在数组arr2中对应的值设为i+1
        }
        return true; // 遍历结束后，说明两个字符串是同构的，返回true
    }
}
