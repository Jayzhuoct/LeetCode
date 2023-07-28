package easy;

import java.util.HashMap;

public class T1两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 11, 9, 7};
        int[] ints = twoSum3(nums, 9);
        if (ints != null) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

    }
    //1.如果数组有序，可以使用双指针法，时间复杂度O(n),空间复杂度O(1)
    /*
    双指针法
    双指针法适用于有序数组，它使用两个指针分别指向数组的开头和结尾，
    然后根据两个指针所指向的元素之和与目标值的大小关系来移动指针，
    直到找到目标值或者指针相遇。双指针法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     */
    public static int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
    //2.如果数组无序，可以使用暴力法，时间复杂度O(n^2),空间复杂度O(1)
    /*
    暴力法
    暴力法是最简单的一种方法，它遍历所有的元素组合，并检查它们的和是否等于目标值。
    暴力法的时间复杂度为 O(n^2)，空间复杂度为 O(1)。
     */
    public static int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    //3.如果数组无序，可以使用HashMap，时间复杂度O(n),空间复杂度O(n)
    /*
    哈希表法
    哈希表法适用于无序数组，它使用哈希表来存储每个元素的下标，
    然后遍历数组，对于每个元素，检查目标值减去这个元素的差是否在哈希表中存在，
    如果存在，说明找到了两个元素的和等于目标值，否则将这个元素的下标存入哈希表。
    哈希表法的时间复杂度为 O(n)，空间复杂度为 O(n)。
    在使用哈希表法时，要注意处理数组中可能存在重复元素的情况。
     */
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (index.containsKey(key)){
                return new int[]{i,index.get(key)};
            }else {
                index.put(nums[i], i);
            }
        }
        return null;
    }

}
