package easy;

import java.util.Arrays;
import java.util.Map;

public class T242有效的字母异位词 {
    public static void main(String[] args) {

    }

    //排序
    //时间复杂度：O(nlogn)
    //空间复杂度：O(logn)
    public boolean isAnagram1(String s, String t) {
        if (s.length() == t.length()){
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(t1);
            return Arrays.equals(s1,t1);
        }
            return false;
    }

    //哈希表
    /*用一个长度为 26 的整数数组 table，记录字符串 s 中每个字母出现的次数，然后遍历字符串 t，
    将 table 中对应的字母出现次数减一，
    如果出现次数小于零，就说明 t 中包含了一个 s 中没有的字母，返回 false。
    如果遍历完整个字符串 t，table 中所有元素都是零，就说明 s 和 t 是字母异位词，返回 true。
    注意，这个算法只适用于字符串中只包含小写字母的情况，
    如果字符串中包含其他字符，需要使用一个更大的数组来记录每个字符的出现次数。*/
    //时间复杂度：O(n),遍历了每个字符串一次，并且在每个位置上只进行了常数次操作
    //空间复杂度：O(1),使用了固定长度的整数数组 table，而不是随着输入数据规模增加而增加的数据结构。
    public boolean isAnagram2(String s, String t) {
        if (s.length() == t.length()){
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                int j = table[t.charAt(i) - 'a'];
                j--;
                if (j < 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //如果输入字符串包含 unicode 字符
    //时间复杂度：O(n),遍历了每个字符串一次，并且在每个位置上只进行了常数次操作
    //空间复杂度：O(S),其中 S 为字符集大小，此处 S=26
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> table = new java.util.HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            table.put(c,table.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            table.put(c,table.getOrDefault(c,0)-1);
            if (table.get(c) < 0){
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

}
