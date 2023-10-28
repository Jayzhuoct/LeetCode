package easy;

public class T383赎金信 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    /*
        思路
        1. 遍历杂志中的每个字符，记录每个字符出现的次数
        2. 遍历勒索信中的每个字符，如果在杂志中找不到对应的字符，返回false
        3. 如果遍历完勒索信中的所有字符，都能在杂志中找到对应的字符，返回true
        时间复杂度O(n)，空间复杂度O(1)
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26]; // 创建一个长度为26的整型数组，用于记录每个字母在杂志中出现的次数
        for (char c : magazine.toCharArray()) { // 遍历杂志中的每个字符
            arr[c - 'a']++; // 将字符转换为对应的数组索引，并将对应位置的值加1，表示该字母在杂志中出现了一次
        }
        for (char c : ransomNote.toCharArray()) { // 遍历勒索信中的每个字符
            if (arr[c - 'a'] == 0) { // 如果数组中对应位置的值为0，表示该字母在杂志中已经用尽，无法构成勒索信
                return false; // 返回false，表示无法构成勒索信
            }
            arr[c - 'a']--; // 将数组中对应位置的值减1，表示使用了一个该字母来构成勒索信
        }
        return true; // 遍历完所有勒索信中的字母，都能在杂志中找到对应的字母，可以构成勒索信，返回true
    }
}
