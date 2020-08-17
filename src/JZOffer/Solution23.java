package JZOffer;

import java.util.List;
import java.util.Stack;

/*
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL


限制：

0 <= 节点个数 <= 5000
 */
public class Solution23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution23 solution23 = new Solution23();
        ListNode node = solution23.reverseList(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode newHead = stack.pop();
        ListNode preNode = newHead;
        while (!stack.isEmpty()) {
            ListNode curNode = stack.pop();
            preNode.next = curNode;
            preNode = curNode;
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
