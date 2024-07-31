package Part2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }


    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push value.");
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop value.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }


    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek value.");
            return -1;
        } else {
            return stackArray[top];
        }
    }


    public boolean isEmpty() {
        return (top == -1);
    }


    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Display stack elements");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int topValue = stack.peek();
                    if (topValue != -1) {
                        System.out.println("Top value: " + topValue);
                    }
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 5:
                    if (stack.isFull()) {
                        System.out.println("Stack is full.");
                    } else {
                        System.out.println("Stack is not full.");
                    }
                    break;
                case 6:
                    stack.display();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
