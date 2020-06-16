
public class IsThisBST {

    static int temp = Integer.MIN_VALUE;
    static Node root;

    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    boolean check(Node root) {


        if (root == null) {
            return true;
        }
        if (!check(root.left)) return false;
        else if (temp >= root.data) return false;
        else {
            temp = root.data;
            if (!check(root.right)) return false;
            // temp = root.data;
            return true;
        }


    }

    boolean checkBST(Node root) {
        return check(root);

    }

    public static void main(String[] args) {
       IsThisBST tree = new IsThisBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.checkBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}

