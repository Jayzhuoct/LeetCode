package easy;

import java.util.*;

public class T349两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 ={9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
    /*
    变量 map 和 set 分别是用来记录元素出现次数和存储交集元素的哈希表和集合。
    在第一个循环中，我们遍历 nums1 数组中的每个元素，将其添加到哈希表 map 中，并记录该元素出现的次数。
    在第二个循环中，我们遍历 nums2 数组中的每个元素，如果当前元素在哈希表 map 中出现过且出现次数大于 0，
    则将其加入到集合 set 中，并将哈希表 map 中对应元素的出现次数减一。
    最后，我们使用 set.toArray() 方法将集合转换成数组，并将其返回作为结果。
    需要注意的是，由于集合中的元素没有特定的顺序，因此返回的数组中的元素顺序也是随机的。
    这个算法的时间复杂度是 O(m+n)，其中 m 和 n 分别是两个数组的长度，因为我们需要遍历两个数组，并且在哈希表中查找元素的出现次数是 O(1) 的时间复杂度。
    空间复杂度也是 O(min(m,n))，因为我们需要使用哈希表和集合来存储数据，而哈希表和集合中的元素个数不会超过两个数组中元素个数的较小值。
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            // map.getOrDefault(i, 0) + 1  如果map中有i这个key，就返回i这个key对应的value，如果没有就返回0
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int j : nums2) {
            // 如果map中有j这个key，并且j这个key对应的value大于0，就把j这个key加入到set中，并且把j这个key对应的value减1
            if (map.containsKey(j) && map.get(j) > 0) {
                set.add(j);
                map.put(j, map.get(j) - 1);
            }
        }
        int[] nums = new int[set.size()];
        int k = 0;
        while (k < set.size()) {
            nums[k] = (int) set.toArray()[k];
            k++;
        }
        return nums;
    }
}
