import java.util.Scanner;

class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void insertAtFirst(int data) {
        Node node = new Node(data);
        if (head == null)
            head = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public static void display() {
        if (head == null) return;
        System.out.println("LinkedList is ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int deleteAtLast() {
        int key;
        if (head == null) {
            System.out.println("LinkedList is empty");
            return -1;
        }
        Node temp1 = head, temp2 = null;
        while (temp1.next != null) {
            temp2 = temp1;
            temp1 = temp1.next;
        }
        if (temp2 == null) {
            key = head.data;
            head = null;
        } else {
            key = temp1.data;
            temp2.next = null;
        }
        return key;
    }

    public static int nthPositionData(int pos){
        Node temp=head;
        while(--pos!=0 && temp!=null){
            temp=temp.next;
        }
        if(temp==null)return -1;
        return temp.data;
    }

    public static int dataPosition(int data){
        Node temp=head;
        int pos=0;
        while(temp!=null && temp.data!=data){
            temp=temp.next;
            pos++;
        }
        if(temp!=null)
            return pos+1;
    return -1;
    }

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        boolean i=true;
        int data, pos;
        while (i) {
            System.out.println("1 for insert at last");
            System.out.println("2 for delete at first");
            System.out.println("3 to display");
            System.out.println("4 for nth position data");
            System.out.println("5 for finding data position");
            System.out.println("6 for exit");

            int n = scr.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter value");
                    data = scr.nextInt();
                    insertAtFirst(data);
                    break;
                case 2:
                    data = deleteAtLast();
                    if (data != -1)
                        System.out.println(data);
                    break;
                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Enter position");
                    pos=scr.nextInt();
                    data=nthPositionData(pos);
                    if(data==-1) System.out.println("Wrong position");
                    else System.out.println(data);
                    break;
                case 5:
                    System.out.println("Enter data");
                    data=scr.nextInt();
                    pos=dataPosition(data);
                    if(pos==-1) System.out.println("Data not found");
                    else System.out.println("Position is " + pos);
                    break;
                case 6:
                    i = false;
                    break;
                default:
                    System.out.println("Wrong option");
            }

        }
    }
}



