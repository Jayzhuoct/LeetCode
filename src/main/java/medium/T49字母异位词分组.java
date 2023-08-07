package medium;


import java.util.*;

public class T49字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"}; // 预期输出结果为 [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams2(strs));
    }

    /*
    1、排序
    时间复杂度：O(nklogk)，其中 n 是字符串数组的长度，k 是字符串数组中字符串的最大长度。
    - 需要遍历 n 个字符串，对于每个字符串，需要 O(klogk) 的时间进行排序以及 O(1) 的时间更新哈希表，因此总时间复杂度是 O(nklogk)。
    空间复杂度：O(nk)，其中 n 是字符串数组的长度，k 是字符串数组中字符串的最大长度。
    - 需要用哈希表存储全部字符串，而记录每个字符串中每个字符出现次数的数组需要的空间为 O(k)。
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        // 创建一个哈希表，用于存储同一组异位词的列表
        Map<String, List<String>> map = new HashMap<>();
        // 遍历给定的字符串数组
        for (String str : strs) {
            // 将当前字符串转换为字符数组，并进行排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 将排序后的字符数组转换为字符串
            String sortedStr = new String(charArray);
            // 如果在哈希表中不存在以排序后的字符串为键的列表，则创建一个新列表并放入哈希表中
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // 将当前字符串放入相应的列表中
            map.get(sortedStr).add(str);
        }
        // 返回哈希表中的所有值（即每一组异位词的列表）
        return new ArrayList<>(map.values());
    }

    /*
    2、计数
    时间复杂度：O(nk)，其中 n 是字符串数组的长度，k 是字符串数组中字符串的最大长度。
    - 需要遍历 n 个字符串，对于每个字符串，需要 O(k) 的时间计算每个字母出现的次数，O(1) 的时间更新哈希表，因此总时间复杂度是 O(nk)。
    空间复杂度：O(nk)，其中 n 是字符串数组的长度，k 是字符串数组中字符串的最大长度。
    - 需要用哈希表存储全部字符串，而记录每个字符串中每个字符出现次数的数组需要的空间为 O(k)。
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        // 创建一个哈希表，用于存储同一组异位词的列表
        Map<String, List<String>> map = new HashMap<>();
        // 遍历给定的字符串数组
        for (String str : strs) {
            // 创建一个长度为 26 的整数数组，用于记录每个字母出现的次数
            int[] count = new int[26];
            // 统计当前字符串中每个字母的出现次数
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            // 构造当前字符串的字符计数数组的唯一标识
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            // 如果在哈希表中不存在以字符计数数组标识为键的列表，则创建一个新列表并放入哈希表中
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将当前字符串放入相应的列表中
            map.get(key).add(str);
        }
        // 返回哈希表中的所有值（即每一组异位词的列表）
        return new ArrayList<>(map.values());
    }
}
