package com.ttn.assignment.feb_22_collection;

import java.util.Scanner;
import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
 * isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
 * (Expected complexity ­ O(1))
 */
public class Exercise7 {
    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        Scanner scanner = new Scanner(System.in);
        char ch;
        do {
            System.out.println("Stack Operations");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check Empty");
            System.out.println("5. Get Minimum");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to push");
                    specialStack.push(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Popped Element = " + specialStack.pop());
                    break;
                case 3:
                    System.out.println("Peek Element = " + specialStack.peek());
                    break;
                case 4:
                    System.out.println("Empty status = " + specialStack.isEmpty());
                    break;
                case 5:
                    System.out.println("Minimum Element = " + specialStack.getMin());
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
        } while (true);
    }
}

/**
 * SpecialStack class extends Stack class for it's basic functionality and overrides those method that are needed for
 * minimum element returning.
 * It has an instance variable of type Stack only namely minStack which is used to store only the element if they are
 * smaller than last minimum element.
 */
class SpecialStack extends Stack<Integer> {
    Stack<Integer> minStack;

    //    Initializing minStack
    public SpecialStack() {
        minStack = new Stack<>();
    }

    //  checking if minStack is empty then adding directly otherwise checking whether the item pushed is smaller or not
//  then pushing if it's smaller.
    @Override
    public Integer push(Integer item) {
        if (minStack.empty()) {
            minStack.push(item);
        } else if (minStack.peek() > item)
            minStack.push(item);
        return super.push(item);
    }

    //  checking if minStack top value is similar to SpecialStack objects top value if it's true then pop both otherwise
//  pop current object's element.
    @Override
    public synchronized Integer pop() {
        if (super.peek().equals(minStack.peek()))
            minStack.pop();
        return super.pop();
    }

    //  returning minimum from top of the minStack as it has minimum value on top always.
    Integer getMin() {
        return minStack.peek();
    }
}