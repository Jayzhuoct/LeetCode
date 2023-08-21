package easy;

import java.util.HashMap;
import java.util.List;

public class T1773统计匹配检索规则的物品数量 {
    public static void main(String[] args) {
        List<List<String>> items = List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")
        );
        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    /*
        时间复杂度：O(n)，其中 n 为物品数量。需要遍历所有物品。
        空间复杂度：O(1)。
     */
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = new HashMap<String, Integer>() {{
            put("type", 0);
            put("color", 1);
            put("name", 2);
        }}.get(ruleKey);
        int res = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
