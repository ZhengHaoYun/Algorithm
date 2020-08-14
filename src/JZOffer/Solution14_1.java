package JZOffer;

/*
剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。


示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
 */
public class Solution14_1 {

    public static void main(String[] args) {

        Solution14_1 solution141 = new Solution14_1();
        System.out.println(solution141.cuttingRope2(10));

    }

    public int cuttingRope(int n) {
        // 创建数组 dp，其中dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
        int[] dp = new int[n + 1];
        // dp[0]=dp[1]=0
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            // 当i >= 2时，假设对正整数 i 拆分出的第一个正整数是 j，则有两种方案，分别是
            // 1. dp[i] = j * (i - j) 表示（i-j）不可拆分
            // 2. dp[i] = j * dp[i - j] 表示（i-j）可继续拆分
            for (int j = 1; j < i; j++) {
                // 因此，当 j 固定时，dp[i]=max(j×(i−j),j×dp[i−j])。由于 j 的取值范围是 1 到 i−1，需要遍历所有的 j 得到 dp[i] 的最大值
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }

        return dp[n];
    }

    // 贪心解法
    public int cuttingRope2(int n) {
        // 切分的越多，乘积越大
        // 但当绳子长度为2或者3的时候，就不应该再切分，因为2=1+1,1*1=1<2,3=1+2,1*2<3
        // 当绳子长度为4的时候，应该切分为2*2，而不是1*3，因为2*2>1*3
        // 所以当绳子长度大于3的时候，就继续切
        if (n <= 3)
            return n - 1;
        int res = 1;

        while ((n - 3) > 0) {

            if (n == 4) {
                res = res * 2;
                n = n - 2;
            } else {
                res = res * 3;
                n = n - 3;
            }
        }
//        while (n > 4) {
//            res = res * 3;
//            n = n - 3;
//        }
        // 长度为n的绳子不断的砍去3，最后绳子的长度可能为1,2,3，所以再乘上最后一段绳子的长度
        return res * n;
    }

}
