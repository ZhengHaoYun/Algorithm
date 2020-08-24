package JZOffer;

/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。



示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。


提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10000
 */
public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] exchange = solution21.exchange(new int[]{1, 2, 3, 4});
        for (int i : exchange) {
            System.out.println(i);
        }
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int left = 0, right = nums.length - 1;
        int temp;
        while (left != right) {

            // 寻找偶数
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            // 寻找奇数
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }

            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}
