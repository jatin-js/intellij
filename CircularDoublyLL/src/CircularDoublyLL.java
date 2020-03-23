import java.util.Scanner;

public class CircularDoublyLL {
    static Node head, tail;
    static class Node{
        int data;
        Node next,prev;
        Node(int data){
            this.data = data;
            next=prev=null;
        }
    }

    static boolean insert(int data, int pos){
        Node node = new Node(data);
//        if(node==null) return false;
        int i;
        Node temp=head;
        for(i=0;i<pos && temp!=tail;i++)
            temp=temp.next;
        if(i!=pos)return false;
        if(temp==null){
            node.prev=node.next=node;
            head=node;
            return true;
        }


        node.next=temp;
        node.prev=temp.prev;
        if(head==tail)
            temp.next=node;
        else
            temp.prev.next=node;
        temp.prev=node;
        return true;
    }

    static int delete(int pos){
        int i;
        if(head==null)return -1;
        Node temp=head;
        for(i=1;i<pos && temp!=tail;i++)
            temp=temp.next;
        if(i!=pos)return -1;
        int data=temp.data;
        if(head==tail){head=tail=null;}
        else {
            data = temp.data;
            Node temp2 = temp.prev;
            temp.prev.next = temp.next;
            temp.next.prev = temp2;
        }
        return data;
    }

    static void display(){
        if(head==null)return;
        Node temp=head;
        do{
            System.out.println(temp.data);
            temp=temp.next;
        }while (temp!=head);
    }


    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int i;
        head=tail=null;
        int Data[]={66,33,4,59,9,8,1,5,2};
        for(i=0;i<9;i++) {
            Node node = new Node(Data[i]);
            if(i==0)tail=node;
            node.next=head;
            if(head!=null)head.prev=node;
            head = node;
        }
        head.prev=tail;
        tail.next=head;
        int data, pos;
        boolean z=true;
        while(z){
            System.out.println(" 1 to insert at starting position");
            System.out.println(" 2 to insert at ending position");
            System.out.println(" 3 to insert at specified position");

            System.out.println("4 to delete at starting position");
            System.out.println("5 to delete at ending position");
            System.out.println("6 to delete at specified position");

            System.out.println("7 to display");

            System.out.println("8 to exit");
            int n = scr.nextInt();
            Node temp;
            switch (n){
                case 1:
                    System.out.println("Enter data");
                    data=scr.nextInt();
                    Node node = new Node(data);
                    node.next=head;
                    node.prev=tail;
                    if(head!=null){
                        tail.next=node;
                        head.prev=node;
                    }
                    head=node;
                    break;
                case 2:  System.out.println("Enter data");
                    data=scr.nextInt();
                    node = new Node(data);
                    node.prev=tail;
                    node.next=head;
                    if(tail!=null) {
                        tail.next = node;
                        head.prev = node;
                    }
                    tail=node;
                    break;
                case 3:
                    System.out.println("Enter data and position");
                    data=scr.nextInt();
                    pos=scr.nextInt();
                    insert(data, pos);
                    break;
                case 4:
                    if(head==null){ System.out.println("No element");continue;}

                    data=head.data;
                    if(head==tail)head=tail=null;
                   else{
                       head=head.next;
                       head.prev=tail;
                       tail.next=head;
                   }

                    System.out.println("Deleted element is " + data);
                    break;
                case 5:
                    if(head==null){ System.out.println("No element");continue;}

                    data=tail.data;
                    if(head==tail)head=tail=null;
                    else {
                        tail = tail.prev;
                        tail.next = head;
                        head.prev = tail;
                    }
                    System.out.println("Delete element is " + data);
                    break;
                case 6:
                    System.out.println("Enter position");
                    pos=scr.nextInt();
                    data=delete(pos);
                    if(data==-1) System.out.println("No element");
                    else
                        System.out.println("Delete element is " + data);
                    break;
                case 7:display();
                break;
                case 8:z=false;
                break;
                default:
                    System.out.println("Wrong option");
            }
        }

    }
}
