package easy;
import java.util.HashMap;
import java.util.Map;

public class T13罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(romanToInt1("MCMXCIV"));
    }
    /*
    首先创建一个哈希表map，将每个罗马数字对应的整数存储到哈希表中。
    然后，遍历字符串s中的每个字符，使用map.get方法查找当前字符对应的整数val。
    如果当前字符表示的整数小于它后面的字符表示的整数，则将结果减去当前字符表示的整数；
    否则将结果加上当前字符表示的整数。最后，返回计算出的结果。
    这个方法的时间复杂度是O(n)，其中n是字符串s的长度。因为这个方法只需要遍历一遍字符串s，并且执行一些常数时间的操作，所以它的时间复杂度是线性的。
    使用哈希表的空间复杂度也是O(n)，因为需要存储每个罗马数字对应的整数。
     */
    public static int romanToInt1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int val = map.get(s.charAt(i));
            if (i < n-1 && val < map.get(s.charAt(i+1))) {
                res -= val;
            } else {
                res += val;
            }
        }
        return res;
    }
    /*
    首先将preNum初始化为字符串s中的第一个字符表示的整数，并将sum初始化为0。
    然后，从第二个字符开始遍历字符串s中的每个字符，将当前字符表示的整数num与preNum进行比较。
    如果num大于preNum，则将preNum从sum中减去；
    否则将preNum加到sum中。最后，将preNum加到sum中，返回计算出的结果。
    这个方法的时间复杂度也是O(n)，其中n是字符串s的长度，因为需要遍历一遍字符串s，并且对于每个字符需要在常数时间内进行比较和更新。
    这种方法的空间复杂度是O(1)，因为只需要存储两个变量preNum和sum。
     */
    public static int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    /*
    使用一个变量prev记录上一个字符表示的整数，如果当前字符表示的整数大于等于prev，则将当前字符表示的整数加到结果中；
    否则将当前字符表示的整数减去2倍的prev，然后再加到结果中。
    具体来说，可以将prev初始化为字符串s中的第一个字符表示的整数，
    然后从第二个字符开始遍历字符串s中的每个字符，将当前字符表示的整数val与prev进行比较。
    如果val大于等于prev，则将val加到结果中，并将prev更新为val；
    否则将2倍的prev减去val加到结果中，并将prev更新为val。
    这个方法的时间复杂度也是O(n)，其中n是字符串s的长度，因为需要遍历一遍字符串s，并且对于每个字符需要在常数时间内进行比较和更新。这
    种方法的空间复杂度是O(1)，因为只需要存储一个变量prev。
     */
    public static int romanToInt3(String s) {
        int prev = getValue(s.charAt(0));
        int res = prev;
        for (int i = 1; i < s.length(); i++) {
            int val = getValue(s.charAt(i));
            if (val > prev) {
                res += val - 2 * prev;
            } else {
                res += val;
            }
            prev = val;
        }
        return res;
    }

    private static int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
