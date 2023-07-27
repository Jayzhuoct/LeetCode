package easy;

import java.util.HashMap;

public class T1两数之和 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])){
                return new int[]{i,index.get(target - nums[i])};
            }else {
                index.put(nums[i], i);
            }
        }
        return null;
    }
}
