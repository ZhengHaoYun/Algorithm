import java.util.*;

public class q3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring2("abcdc"));
    }
}

class Solution {
    /*
        方法一：双指针滑动窗口
        最坏情况下：每个元素都可能访问两次，复杂度为O(2N)，如：ancdc，每个元素都访问了两次。
     */
    public int lengthOfLongestSubstring1(String s) {
        int start = 0, end = 0, result = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        HashSet<Character> hashSet = new HashSet<>();
        while (start < n && end < n) {
            if (hashSet.contains(chars[end])) {
                hashSet.remove(chars[start]);
                start++;
            } else {
                hashSet.add(chars[end]);
                end++;
                result = Math.max(result, end - start);
            }

        }
        return result;

    }

    /*
        优化：我们可以定义字符到索引的映射，而不是简单通过一个集合来判断字符是否存在。
        这样的话，当我们找到重复的字符时，我们可以立即跳过该窗口，而不需要对之前的元素进行再次访问。
        比如说abcdc，当end指针指向c的时候，直接让start指针指向d，而不是如之前一样慢慢移动。
        通过start = Math.max(start, map.get(chars[end]) + 1);这条语句去改变start指针。
     */
    public int lengthOfLongestSubstring2(String s) {
        int start = 0, end = 0, result = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (start < n && end < n) {
            if (map.containsKey(chars[end])) {
                start = Math.max(start, map.get(chars[end]) + 1);
            }
            map.put(chars[end], end);
            end++;
            result = Math.max(result, end - start);

        }
        return result;
    }

}
