package JZOffer;

/*
剑指 Offer 30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.


提示：

各函数的调用总次数不超过 20000 次
 */
public class Solution30 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.min();
        System.out.println(param_3);
        System.out.println(param_4);
    }

}

class MinStack {

    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }

}

class Node {
    int val;
    Node next;
    int min;

    public Node(int val, int min, Node next) {
        this.min = min;
        this.val = val;
        this.next = next;
    }
}
