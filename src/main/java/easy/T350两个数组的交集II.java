package easy;

import java.util.*;


public class T350两个数组的交集II {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 ={2,2};
        System.out.println(Arrays.toString(intersect1(nums1,nums2)));
    }
    /*
    时间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。
    需要遍历两个数组并对哈希表进行操作，哈希表操作的时间复杂度是 O(1)，
    因此总时间复杂度与两个数组的长度和呈线性关系。

    空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个数组的长度。
    对较短的数组进行哈希表的操作，哈希表的大小不会超过较短的数组的长度。
    为返回值创建一个数组 intersection，其长度为较短的数组的长度。
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        // 如果 nums1 的长度大于 nums2 的长度，则交换它们，保证 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        // 创建哈希表，记录 nums1 中每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        // 创建交集数组 intersection，记录两个数组的交集
        int[] intersection = new int[nums1.length];
        int index = 0;
        // 遍历 nums2 数组，如果当前数字在哈希表中存在，则将其加入交集数组中，并将哈希表中该数字的出现次数减 1
        // 如果减 1 后出现次数为 0，则从哈希表中移除该数字
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        // 截取交集数组的有效部分，返回交集数组
        return Arrays.copyOfRange(intersection, 0, index);
    }


    /*
    时间复杂度：O(mlogm+nlogn)，其中 m 和 n 分别是两个数组的长度。
    对两个数组进行排序的时间复杂度是 O(mlogm+nlogn)，
    遍历两个数组的时间复杂度是 O(m+n)，因此总时间复杂度是 O(mlogm+nlogn)

    空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个数组的长度。
    为返回值创建一个数组 intersection，其长度为较短的数组的长度。
    不过在 C++ 中，我们可以直接创建一个 vector，不需要把答案临时存放在一个额外的数组中，
    所以这种实现的空间复杂度为 O(1)。
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // 对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 使用双指针法找出两个数组中相同的元素
        int i = 0, j = 0, k = 0;
        int[] nums = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums[k++] = nums1[i];
                i++;
                j++;
            }
        }
        // 截取交集数组的有效部分，返回交集数组
        return Arrays.copyOfRange(nums, 0, k);
    }
}
