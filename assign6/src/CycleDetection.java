public class CycleDetection {

    static SinglyLinkedListNode head;

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int d)
        {
            data = d;
            next = null;
        }
    }

    static public void push(int new_data)
    {

        SinglyLinkedListNode new_node = new SinglyLinkedListNode(new_data);

        new_node.next = head;

        head = new_node;
    }


    static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null) return false;
        SinglyLinkedListNode temp1, temp2;
        temp1 = temp2 = head;
        while (temp2 != null && temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
            if (temp1 == temp2)
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        CycleDetection llist = new CycleDetection();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        llist.head.next.next.next.next = llist.head;

        if (hasCycle(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}


