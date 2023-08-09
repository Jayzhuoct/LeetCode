package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4}; // 创建数组
        System.out.println(threeSum(nums)); // 输出三数之和为0的三元组
    }

    /*
    排序+双指针
    首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的两端，数字分别为nums[left]和nums[right]，计算三个数的和sum判断是否满足为0，满足则添加进结果集
    如果nums[i]大于0，则三数之和必然无法等于0，结束循环
    如果nums[i]==nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
    当sum==0时，nums[left]==nums[left+1]则会导致结果重复，应该跳过，left++
    当sum==0时，nums[right]==nums[right-1]则会导致结果重复，应该跳过，right--
    时间复杂度:O(n^2)
    外层for循环需遍历长度为n的数组,时间复杂度为O(n)
    内层while循环在最坏情况下需要遍历整个数组,时间复杂度为O(n)
    所以总时间复杂度为O(n^2)
    空间复杂度:O(1)
    结果res列表中的元素数量与输入无关,可以看作常数级别
    排序需要O(1)的额外空间
    所以空间复杂度为O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 结果列表
        Arrays.sort(nums); // 对数组排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result; // 如果当前数字大于0,说明后面不可能有三数之和为0,直接返回结果
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去重,当前数字和前一个数字相同则跳过
            int left = i + 1;
            int right = nums.length - 1; // 左右指针分别指向当前数字后面的左右两端
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // 计算三数之和
                if (sum > 0) right--; // 如果大于0,移动右指针向左缩小和
                else if (sum < 0) left++; // 如果小于0,移动左指针向右扩大和
                else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right])); // 如果等于0,记录结果
                    while (left < right && nums[right] == nums[right-1]) right--; // 去重,移动右指针
                    while (left < right && nums[left] == nums[left+1]) left++; // 去重,移动左指针
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
