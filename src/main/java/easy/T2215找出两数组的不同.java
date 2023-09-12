package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2215找出两数组的不同 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,3,4,6};
        System.out.println(findDifference(nums1, nums2));
    }
    /*
        * 哈希表
        * 时间复杂度：O(n+m)，其中 n 和 m 分别是数组 nums1 和 nums2 的长度。
        * 需要遍历数组 nums1 和 nums2 各一次，对于 nums1 中的每个元素，需要遍历 nums2 判断是否存在相同的元素。
        * 空间复杂度：O(n+m)，其中 n 和 m 分别是数组 nums1 和 nums2 的长度。
     */
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 创建两个哈希表，用于存储nums1和nums2中元素及其索引的对应关系
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        // 构建nums1的哈希表
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], i);
        }

        // 构建nums2的哈希表
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], i);
        }

        // 存储nums2中不在nums1中出现的元素
        List<Integer> list2 = new ArrayList<>();
        map2.forEach((k, v) -> {
            if (null == map1.get(k)) {
                list2.add(k);
            }
        });

        // 存储nums1中不在nums2中出现的元素
        List<Integer> list1 = new ArrayList<>();
        map1.forEach((k, v) -> {
            if (null == map2.get(k)) {
                list1.add(k);
            }
        });

        // 构建结果列表
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        return result;
    }
}
