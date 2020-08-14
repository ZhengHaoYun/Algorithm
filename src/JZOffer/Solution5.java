package JZOffer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *  
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.replaceSpace2("We are happy."));
    }
}
