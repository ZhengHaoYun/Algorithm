package leetcode;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution3 {
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
