package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }

    /*
        回溯
        时间复杂度：O(3^m * 4^n)
        空间复杂度：O(m + n)
     */
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        // 映射每个数字对应的字母组合
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // 开始回溯
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果已经遍历完了所有的数字，将当前的组合添加到结果列表中
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 获取当前数字对应的字母组合
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 遍历当前数字对应的每个字母
            for (int i = 0; i < lettersCount; i++) {
                // 将当前字母添加到当前的组合中
                combination.append(letters.charAt(i));
                // 继续下一个数字的回溯
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯，将当前字母从组合中删除，尝试下一个字母
                combination.deleteCharAt(index);
            }
        }
    }
}
