package com.linsen.algorithms.force;

import java.util.Stack;

/**
 * @author: linsen
 * @date: 2022/2/13
 * @description: 不实用额外空间，使用递归函数逆序一个栈
 */
public class ReverseHeapDemo {


    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }


    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
