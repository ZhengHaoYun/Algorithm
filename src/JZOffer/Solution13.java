package JZOffer;

import java.util.LinkedList;
import java.util.Queue;

/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
 */
public class Solution13 {


    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x >= m || node.y >= n || node.sx + node.sy > k || visited[node.x][node.y])
                continue;
            count++;
            visited[node.x][node.y] = true;
            queue.add(new Node(node.x + 1, node.y));
            queue.add(new Node(node.x, node.y + 1));
        }
        return count;
    }

    class Node {
        int x;
        int y;
        int sx;
        int sy;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            while (x != 0) {
                this.sx += x % 10;
                x /= 10;
            }
            while (y != 0) {
                this.sy += y % 10;
                y /= 10;
            }
        }
    }
}

