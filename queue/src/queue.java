import java.util.*;

class Queue
{
    private int arr[];
    private int front, rear;
    private int capacity;

    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = rear = -1;
    }

    public void enqueue(int x)
    {
        if (isFull())
        {
            System.out.println("Queue is full");
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
        if(front==-1)front=0;
        arr[++rear] = x;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
//            System.exit(1);
            return -1;
        }

//        System.out.println("Removing " + peek());

        int i;
        int data=arr[front];
        for(i=front;i<rear;i++){
            arr[i]=arr[i+1];
        }
        if(front==rear)
            front=-1;
        rear--;

        return data;
    }

    public int peek()
    {
        if (!isEmpty())
            return arr[rear];
        return -1;
    }

    public Boolean isEmpty()
    {
        return front == -1;
    }

    public Boolean isFull()
    {
        return rear-front == capacity - 1;
    }

    public static void main (String[] args)
    {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter size of queue");
        int size=scr.nextInt();
        Queue queue = new Queue(size);
        boolean i=true;
        int data;
        while(i){
            System.out.println("1 for enqueue");
            System.out.println("2 for dequeue");
            System.out.println("3 for peek");
            System.out.println("4 for exit");
            int n= scr.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter value");
                    data=scr.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    data=queue.dequeue();
                    if(data!=-1)
                        System.out.println(data);
                    break;
                case 3:
                    data=queue.peek();
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
