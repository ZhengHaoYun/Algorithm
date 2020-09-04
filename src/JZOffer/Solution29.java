package JZOffer;

import java.util.Arrays;

/*
剑指 Offer 29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
 */
public class Solution29 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution29 s = new Solution29();
        int[] ints = s.spiralOrder(a);
        System.out.println(Arrays.toString(ints));
    }


    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int size = matrix[0].length * matrix.length;
        int left = 0;
        int up = 0;
        int index = 0;
        int[] res = new int[size];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[up][i];
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[down][i];
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right)
                break;
        }

        return res;


    }


}
