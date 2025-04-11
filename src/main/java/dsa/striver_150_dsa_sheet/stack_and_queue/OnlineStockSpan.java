package dsa.striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class OnlineStockSpan {
    class Pair {
        int price;
        int index;

        Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
    Stack<Pair> stack;
    int time = 0;
    public OnlineStockSpan() {
        stack = new Stack<>();
    }
    public int next(int price) {

        Pair pair = new Pair(price, time);
        time++;
        int ans;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            ans = time;
        } else {
            ans = pair.index - stack.peek().index;
        }
        stack.push(pair);
        return ans;
    }

    public static void main(String[] args) {
        OnlineStockSpan osp = new OnlineStockSpan();
        System.out.println(osp.next(100)); // return 1
        System.out.println(osp.next(80));  // return 1
        System.out.println(osp.next(60));  // return 1
        System.out.println(osp.next(70));  // return 2
        System.out.println(osp.next(60));  // return 1
        System.out.println(osp.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(osp.next(85));  // return 6

    }
}
