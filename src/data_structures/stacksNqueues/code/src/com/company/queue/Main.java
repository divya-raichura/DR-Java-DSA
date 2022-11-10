package src.data_structures.stacksNqueues.code.src.com.company.queue;

import com.company.stack.CustomStack;
import com.company.stack.DynamicStack;
import com.company.stack.StackException;

public class Main {
    public static void main(String[] args) throws StackException {
        CustomStack stack = new DynamicStack();
        stack.push(11);
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
    }
}
