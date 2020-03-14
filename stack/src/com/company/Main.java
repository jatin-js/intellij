package com.company;

import java.util.*;

class Stack
{
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Stack Overflow");
//            System.exit(1);
            int i;
            int arr[]=new int[2*capacity];
            for(i=0;i<capacity;i++){
                arr[i]=this.arr[i];
            }
            this.arr=arr;
            capacity *= 2;
        }

//        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
//            System.exit(1);
            return -1;
        }

//        System.out.println("Removing " + peek());

        return arr[top--];
    }

    public int peek()
    {
        if (!isEmpty())
            return arr[top];
        return -1;
    }

    public Boolean isEmpty()
    {
        return top == -1;
    }

    public Boolean isFull()
    {
        return top == capacity - 1;
    }

    public static void main (String[] args)
    {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter size of stack");
        int size=scr.nextInt();
        Stack stack = new Stack(size);
        boolean i=true;
        int data;
        while(i){
            System.out.println("1 for push");
            System.out.println("2 for pop");
            System.out.println("3 for peek");
            System.out.println("4 for exit");
            int n= scr.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter value");
                    data=scr.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    data=stack.pop();
                    if(data!=-1)
                        System.out.println(data);
                    break;
                case 3:
                    data=stack.peek();
                    if(data!=-1)
                        System.out.println(data);
                    break;
                case 4:
                    i=false;
                    break;
                default:
                    System.out.println("Wrong option");
            }

        }
    }
}