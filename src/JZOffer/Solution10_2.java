package JZOffer;

import sun.security.provider.Sun;

/*
剑指 Offer 10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
提示：
0 <= n <= 100
 */
public class Solution10_2 {
    /*
        青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
        当为 1 级台阶： 剩 n-1 个台阶，此情况共有 f(n-1) 种跳法；
        当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
        f(n)=f(n-1)+f(n-2)
        空间复杂度o（n），时间复杂度o（n）
     */
    public int numWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000_000_007;
        }

        return dp[n];
    }

    /*
     空间：o（1），时间o（n）
     */
    public int numWays2(int n) {
        if (n == 0 || n == 1)
            return 1;
        int pre = 1, cur = 2, sum;
        for (int i = 3; i <= n; i++) {
            sum = (pre + cur) % 1000_000_007;
            pre = cur;
            cur = sum;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution10_2 solution10_2 = new Solution10_2();
        System.out.println(solution10_2.numWays2(7));
    }
}
