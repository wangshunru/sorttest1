package leetcode;

import java.util.Stack;

/**
 * Created by wangshunxi on 2020/5/12.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MinStack_155 {
    /** initialize your data structure here. */

    /*int min = Integer.MAX_VALUE;   //当前最小元素的值
    Stack<Integer> stack = new Stack<Integer>();*/

    long min;
    Stack<Long> stack;

    public MinStack_155() {
        stack = new Stack<Long>();
    }
    public void push(int x) {
        /*if (x <= min){
            //将之前的最小值入栈
            stack.push(min);
            min = x;  //更新最小值
        }
        stack.push(x);*/
        if (stack.isEmpty()){
            min = x;
            stack.push(x-min);
        }else {
            stack.push(x - min);
            if (x < min){
                min = x;
            }
        }

    }

    public void pop() {
        /*//如果弹出的是最小值 将下一个元素弹出作为最小值
        if (stack.pop() == min){
            min = stack.pop();
        }*/
        if (stack.isEmpty()){
            return;
        }
        Long pop = stack.pop();
        if (pop < 0){
            min = min - pop;
        }
    }

    public int top() {
        /*return stack.peek();*/
        Long top = stack.peek();
        if (top < 0){
            return (int)min;
        }
        else {
            return (int)(top + min);
        }
    }

    public int getMin() {
        /*return min;*/
        return (int)min;
    }
}
