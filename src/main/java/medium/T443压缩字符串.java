package medium;

public class T443压缩字符串 {
    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(compress(chars));
    }

    /*
        * 双指针
        * 时间复杂度：O(n)，其中 n 是字符数组的长度
        * 空间复杂度：O(1)
     */
    public static int compress(char[] chars) {
        int len = chars.length;  // 获取字符数组的长度
        int left = 0;  // 左指针，指向当前字符连续序列的起始位置
        int right = 0;  // 右指针，指向当前字符连续序列的结束位置的下一个位置
        int index = 0;  // 输出结果的索引位置，也表示压缩后的字符数组长度
        while (right < len) {  // 循环遍历字符数组
            while (right < len && chars[left] == chars[right]) {
                right++;  // 向右移动右指针，直到找到不同的字符或者到达字符数组末尾
            }
            chars[index++] = chars[left];  // 将当前字符（连续序列的起始字符）存入压缩后的字符数组中
            if (right - left > 1) {  // 如果字符连续序列长度大于1
                String count = right - left + "";  // 将连续序列的长度转换为字符串
                for (int i = 0; i < count.length(); i++) {
                    chars[index++] = count.charAt(i);  // 将连续序列的长度存入压缩后的字符数组中
                }
            }
            left = right;  // 更新左指针为右指针的位置，继续处理下一个字符连续序列
        }
        return index;  // 返回压缩后的字符数组长度
    }
}
