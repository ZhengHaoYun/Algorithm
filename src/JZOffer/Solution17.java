package JZOffer;

public class Solution17 {

    public int[] printNumbers(int n) {
        int[] nums = new int[(int) (Math.pow(10, n) - 1)];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        return nums;
    }
}
