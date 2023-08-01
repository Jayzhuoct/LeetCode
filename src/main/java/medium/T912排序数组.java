package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T912排序数组 {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 冒泡排序
     * @param nums 待排序数组
    当我们使用计算机程序对一个数组进行冒泡排序时，程序会重复遍历整个数组，比较相邻的元素，
    如果它们的顺序不对就交换它们的位置。这个算法的名字“冒泡排序”来自于这样一个现象：
    在排序的过程中，较小的元素会向数组的顶部“冒泡”。
    在排序的第一轮中，程序会比较数组中的前两个元素，如果它们的顺序不对就交换它们的位置。
    然后程序会比较数组中的第二个和第三个元素，以此类推，直到比较了整个数组。在第一轮排序之后，
    数组中最小的元素会被放在数组的第一个位置。
    接下来的每一轮排序都会将数组中当前未排序部分的最小元素放到已排序部分的末尾。
    冒泡排序的时间复杂度是 O(n^2)，因此它的效率比其他排序算法如归并排序和快速排序要低。
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {  // 外层循环，控制排序轮数
            for (int j = 0; j < nums.length - i - 1; j++) {  // 内层循环，控制每轮比较的次数
                if (nums[j] > nums[j + 1]) {  // 如果相邻两个元素顺序不对
                    int temp = nums[j];  // 交换它们的位置
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param nums 待排序数组
    首先找到未排序部分的最小元素，将它和未排序部分的第一个元素交换位置，
    然后将已排序部分的末尾向右移动一位。接着，在剩余的未排序部分中继续寻找最小元素，
    并重复上述过程，直到整个数组都被排序。选择排序的时间复杂度也是 O(n^2)，
    因此对于大规模的数据排序来说，效率不高。
     */
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {  // 外层循环，控制排序轮数
            int minIndex = i;  // 假设当前未排序部分的第一个元素是最小的
            for (int j = i + 1; j < nums.length; j++) {  // 内层循环，找到未排序部分的最小元素
                if (nums[j] < nums[minIndex]) {  // 如果找到一个更小的元素
                    minIndex = j;  // 更新最小元素的下标
                }
            }
            int temp = nums[i];  // 将最小元素放到已排序部分的末尾
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    /**
     * 插入排序
     * @param nums 待排序数组
    将未排序部分的第一个元素插入到已排序部分的合适位置，使得已排序部分依然有序。
    具体实现是从第二个元素开始，将它和已排序部分从后往前比较，找到它应该插入的位置，
    然后将已排序部分中的元素向右移动一位，为待插入元素腾出位置。
    插入排序的时间复杂度也是 O(n^2)，但是相对于冒泡排序和选择排序，
    它的常数因子较小，因此在小规模的数据排序中，插入排序的效率比较高。
     */
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {  // 外层循环，控制待插入元素的位置
            int temp = nums[i];  // 保存待插入元素的值
            int j = i - 1;  // j 指向已排序部分的末尾
            while (j >= 0 && nums[j] > temp) {  // 内层循环，将待插入元素插入到已排序部分的合适位置
                nums[j + 1] = nums[j];  // 如果已排序部分的元素比待插入元素大，将它向右移动一位
                j--;  // 继续向前寻找插入位置
            }
            nums[j + 1] = temp;  // 将待插入元素插入到已排序部分的合适位置
        }
    }

    /**
     * 希尔排序
     * @param nums 待排序数组
     *
     * 思路：
     * 1. 初始化一个间隔 gap，将数组分成 gap 个子序列，对每个子序列进行插入排序
     * 2. 缩小间隔 gap，重复上述操作，直到 gap 为 1，此时对整个数组进行一次插入排序
     * 3. 希尔排序的关键在于选择合适的间隔序列，常用的间隔序列有希尔增量和 Sedgewick 增量
    希尔排序是插入排序的一种改进算法，它通过先将数组分成若干个子序列，对每个子序列进行插入排序，
    然后逐步缩小子序列的长度，最后对整个数组进行一次插入排序来完成排序。希尔排序的关键在于选择合适的间隔序列，
    通常是使用希尔增量或 Sedgewick 增量的方式来确定间隔序列。希尔排序的时间复杂度为 O(n^2)，
    但是实际运行效率因间隔序列的选择而异，通常情况下比简单插入排序更优秀。
     */
    public static void shellSort(int[] nums) {
        int gap = nums.length / 2;  // 初始化间隔序列为数组长度的一半
        while (gap > 0) {  // 不断缩小间隔序列，直到间隔为 1
            for (int i = gap; i < nums.length; i++) {  // 对每个间隔序列进行插入排序
                int temp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
            gap /= 2;  // 缩小间隔序列
        }
    }

    /**
     * 归并排序
     * @param nums 待排序数组
     * @param left 左边界
     * @param right 右边界
     * 思路：
     * 1. 将待排序数组分成两个子数组，分别对左右两个子数组进行递归排序
     * 2. 将左右两个已排序的子数组合并成一个有序的数组
     * 3. 归并排序的关键在于合并两个有序的子数组，通常使用临时数组来存储合并后的结果
    归并排序是一种采用分治思想的排序算法，它将待排序数组分成两个子数组，分别对左右两个子数组进行递归排序，
    然后将两个已排序的子数组合并成一个有序的数组。归并排序的关键在于合并两个有序的子数组，
    通常使用临时数组来存储合并后的结果。归并排序的时间复杂度为 O(nlogn)，相对于其他 O(nlogn) 的排序算法，
    如快速排序和堆排序，归并排序在最坏情况下仍具有稳定性，因此在需要稳定排序的情况下，归并排序是一种更好的选择。
     */
    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {  // 当左右边界相等或左边界大于右边界时，结束递归
            return;
        }
        int mid = (left + right) / 2;  // 计算数组中间位置
        mergeSort(nums, left, mid);  // 对左半部分进行归并排序
        mergeSort(nums, mid + 1, right);  // 对右半部分进行归并排序
        int[] temp = new int[right - left + 1];  // 创建一个临时数组，用于存放排序后的结果
        int i = left, j = mid + 1, k = 0;  // i、j 分别指向左右两个子数组的头部，k 指向临时数组的头部
        while (i <= mid && j <= right) {  // 当左右两个子数组都有元素时
            if (nums[i] <= nums[j]) {  // 如果左边的元素小于等于右边的元素
                temp[k++] = nums[i++];  // 将左边的元素放入临时数组中，i 指针后移
            } else {
                temp[k++] = nums[j++];  // 否则将右边的元素放入临时数组中，j 指针后移
            }
        }
        while (i <= mid) {  // 如果左边的子数组还有元素未放入临时数组中
            temp[k++] = nums[i++];  // 将剩余的元素全部放入临时数组中
        }
        while (j <= right) {  // 如果右边的子数组还有元素未放入临时数组中
            temp[k++] = nums[j++];  // 将剩余的元素全部放入临时数组中
        }
        for (int p = 0; p < temp.length; p++) {  // 将临时数组中的元素复制回原数组中
            nums[left + p] = temp[p];
        }
    }

    /**
     * 堆排序
     * @param nums 待排序数组
     *
     * 思路：
     * 1. 构建初始堆，将待排序数组转化为一个最大堆或最小堆
     * 2. 不断取出堆顶元素，放到已排序的序列中，然后重新调整堆，使其仍然是一个最大堆或最小堆
     * 3. 堆排序的关键在于堆的调整，通常使用“向下调整”或“向上调整”来维护堆的性质
    堆排序是一种选择排序，它利用堆这种数据结构来进行排序。堆可以被看成一棵完全二叉树，每个节点都比它的子节点大（或小），
    这样的堆叫做最大堆（或最小堆）。堆排序的主要思路是先将待排序的序列构建成一个最大堆（或最小堆），
    然后不断取出堆顶元素，放到已排序的序列中，然后重新调整堆，使其仍然是一个最大堆（或最小堆）。
    堆排序的时间复杂度为 O(nlogn)，相对于快速排序和归并排序，堆排序在最坏情况下的时间复杂度也是 O(nlogn)，
    因此在需要保证时间复杂度稳定的情况下，堆排序是一种比较好的选择。
     */
    public static void heapSort(int[] nums) {
        // 构建初始堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        // 不断取出堆顶元素，放到已排序的序列中
        for (int i = nums.length - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeap(nums, 0, i);
        }
    }

    /**
     * 调整堆
     * @param nums 待调整的数组
     * @param i 要调整的节点下标
     * @param length 堆的长度
     */
    private static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];  // 先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {  // 从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && nums[k] < nums[k + 1]) {  // 如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (nums[k] > temp) {  // 如果子节点大于父节点，将子节点赋值给父节点（不用进行交换）
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;  // 将temp值放到最终的位置
    }

    /**
     * 计数排序
     * @param nums 待排序数组
     * 思路：
     * 1. 遍历待排序数组，找到最大值和最小值
     * 2. 创建一个计数数组 count，长度为最大值和最小值之差加上1
     * 3. 遍历待排序数组，将每个元素出现的次数记录到 count 数组中
     * 4. 遍历 count 数组，将每个元素按照计数值的大小依次放入待排序数组中
     * 注意：计数排序的时间复杂度为 O(n+k)，其中 k 是最大值和最小值之差
    计数排序是一种非比较排序，它利用桶（计数数组）来统计每个元素在待排序数组中出现的次数，
    然后按照计数值的大小依次将元素放回原数组中。计数排序的时间复杂度为 O(n+k)，其中 k 是最大值和最小值之差，
    因此对于比较集中的数据，计数排序是一种更好的选择。计数排序的缺点是需要额外的空间来存储计数数组，
    如果元素的范围比较大，会占用大量的空间。
     */
    public static void countingSort(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {  // 找到最大值和最小值
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] count = new int[max - min + 1];  // 创建计数数组
        for (int i = 0; i < nums.length; i++) {  // 遍历待排序数组，记录每个元素出现的次数
            count[nums[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {  // 遍历计数数组，将每个元素按照计数值的大小依次放入待排序数组中
            while (count[i] > 0) {
                nums[index++] = i + min;
                count[i]--;
            }
        }
    }

    /**
     * 桶排序
     * @param nums 待排序数组
     * @param bucketSize 桶的大小
     * 思路：
     * 1. 遍历待排序数组，找到最大值和最小值
     * 2. 计算桶的个数 bucketCount，每个桶的大小为 bucketSize
     * 3. 创建 bucketCount 个桶，将每个元素放入对应的桶中
     * 4. 对每个桶中的元素进行排序
     * 5. 遍历每个桶，将桶中的元素按照顺序放回待排序数组中
     * 注意：桶排序的时间复杂度为 O(n)，但是需要额外的空间来存储桶
    桶排序是一种线性排序算法，它利用桶将待排序数组中的元素分到不同的桶中，然后对每个桶中的元素进行排序，
    最后将桶中的元素按照顺序放回原数组中。桶排序的时间复杂度为 O(n)，但是需要额外的空间来存储桶。
    桶排序适用于元素分布比较均匀的情况下，如果元素分布不均匀，某些桶中的元素会很多，而某些桶中的元素会很少，
    这样就会浪费大量的空间。
     */
    public static void bucketSort(int[] nums, int bucketSize) {
        if (nums.length == 0) {
            return;
        }
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {  // 找到最大值和最小值
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;  // 计算桶的个数
        List<List<Integer>> buckets = new ArrayList<>();  // 创建桶
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {  // 将每个元素放入对应的桶中
            int bucketIndex = (nums[i] - min) / bucketSize;
            buckets.get(bucketIndex).add(nums[i]);
        }
        int index = 0;
        for (int i = 0; i < buckets.size(); i++) {  // 对每个桶中的元素进行排序，然后将桶中的元素按照顺序放回待排序数组中
            List<Integer> bucket = buckets.get(i);
            Collections.sort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                nums[index++] = bucket.get(j);
            }
        }
    }

    /**
     * 基数排序
     * @param nums 待排序数组
     * 思路：
     * 1. 找到数组中的最大值 max，计算出最大值的位数 digitCount
     * 2. 从低位到高位，依次对每个数字进行排序
     * 3. 对于每个数字，按照当前位数上的数字进行桶排序
     * 4. 按照桶排序的结果，将数字按照顺序放回原数组中
     * 注意：基数排序的时间复杂度为 O(dn)，其中 d 是最大值的位数
    基数排序是一种多关键字排序算法，它将待排序数组中的元素按照每个元素的位数依次进行排序。
    基数排序首先找出待排序数组中的最大值 max，计算出它的位数 digitCount，
    然后从低位到高位，依次对每个数字进行桶排序。对于每个数字，按照当前位数上的数字进行桶排序，
    然后按照桶排序的结果，将数字按照顺序放回原数组中。基数排序的时间复杂度为 O(dn)，其中 d 是最大值的位数。
    它的时间复杂度比较稳定，但是需要额外的空间来存储中间结果。
     */
    public static void radixSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {  // 找到数组中的最大值
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int digitCount = 0;
        while (max > 0) {  // 计算出最大值的位数
            digitCount++;
            max /= 10;
        }
        int exp = 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < digitCount; i++) {  // 从低位到高位，依次对每个数字进行排序
            int[] count = new int[10];  // 创建桶
            for (int j = 0; j < nums.length; j++) {  // 对于每个数字，按照当前位数上的数字进行桶排序
                int digit = (nums[j] / exp) % 10;
                count[digit]++;
            }
            for (int j = 1; j < 10; j++) {  // 累加桶中元素的个数
                count[j] += count[j - 1];
            }
            for (int j = nums.length - 1; j >= 0; j--) {  // 将数字按照顺序放回原数组中
                int digit = (nums[j] / exp) % 10;
                temp[count[digit] - 1] = nums[j];
                count[digit]--;
            }
            System.arraycopy(temp, 0, nums, 0, nums.length);
            exp *= 10;
        }
    }

}
