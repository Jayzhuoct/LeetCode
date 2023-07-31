package easy;

import java.util.Arrays;

public class T88合并两个有序数组 {
    public static void main(String[] args) {
        int [] nums1 = {7,8,9,10,0,0};
        int [] nums2 = {1,2,3,4,5};
        merge2(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));

    }
    //直接合并后排序
    //时间复杂度：O((n+m)log(n+m))。空间复杂度：O(1)。
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while (i < n) {
            nums1[m+i] = nums2[i];
            i++;
        }
        Arrays.sort(nums1);
    }
    //逆向指针
    /*
    i 指向 nums1 的最后一个元素，
    j 指向 nums2 的最后一个元素，
    k 指向最终合并后的数组中的最后一个位置。
    从后往前遍历两个数组，每次将较大的元素放到 nums1 数组的末尾，
    同时向前移动指针 i 或 j，直到其中一个指针到达数组的开头。
    如果此时 nums2 中还有剩余的元素，我们将它们复制到 nums1 中即可*/
    //时间复杂度：O(n+m)。空间复杂度：O(1)。
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
