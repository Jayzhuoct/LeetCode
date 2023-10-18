package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1268搜索推荐系统 {
    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> list = suggestedProducts(products,searchWord);
        for (List<String> l : list) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    /*
        二分查找+字符串排序
        对产品数组 products 进行排序，以便后面进行二分查找。
        遍历搜索词的每个字母，利用前缀的逐步扩展，逐个生成建议产品列表。
        在每个位置 i，获取当前位置之前的子串 pre。
        使用二分查找找到第一个以 pre 开头的单词的索引，通过不断更新左右边界 l 和 r 来实现。
        创建一个 curList 用于存储当前位置的建议产品列表。
        从索引 l 开始，遍历最多 3 个单词，将符合条件的单词（以 pre 开头）添加到 curList 中。
        将 curList 添加到总的建议产品列表 list 中。
        返回最终的建议产品列表 list。

        时间复杂度：O(nlogn)，其中 n 是搜索词的长度。
        空间复杂度：O(logN)，即为排序需要使用的栈空间。
     */
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // 对产品数组进行排序，以便后面进行二分查找
        int n = searchWord.length(); // 搜索词的长度
        List<List<String>> list = new ArrayList<>(); // 用于存储建议的产品列表
        for (int i = 0; i < n; i++) { // 遍历搜索词的每个字母
            String pre = searchWord.substring(0, i + 1); // 获取当前位置之前的子串
            int l = 0, r = products.length; // 初始化二分查找的左右边界
            // 使用二分查找找到第一个以pre开头的单词
            while (l < r) {
                int mid = (l + r) / 2; // 计算中间位置
                String curPre = products[mid].substring(0, Math.min(i + 1, products[mid].length())); // 获取当前单词的前缀
                if (curPre.compareTo(pre) < 0) // 当前前缀小于pre，说明目标单词在后半部分
                    l = mid + 1; // 更新左边界
                else
                    r = mid; // 更新右边界
            }
            List<String> curList = new ArrayList<>(); // 用于存储当前位置的建议产品列表
            // 将符合条件的单词添加到curList中
            for (int j = l; j < Math.min(products.length, l + 3); j++) {
                // 如果当前单词不以pre开头，直接退出循环，后面的单词也不会以pre开头
                if (!products[j].startsWith(pre))
                    break;
                curList.add(products[j]); // 将符合条件的单词添加到curList中
            }
            list.add(curList); // 将curList添加到总的建议产品列表中
        }
        return list; // 返回建议产品列表
    }
}
