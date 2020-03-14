import java.util.Scanner;

class Check{
    void check(int n1, int n2){
        int a=(int)(Math.random()*10);
        int b=(int)(Math.random()*10);
        System.out.println(a);
        System.out.println(b);
        if(a==n1 && b==n2)
            System.out.println("You won $1,00,000");
        else if(a==n2 && b==n1)
            System.out.println("You won $50,000");
        else if(a==n1 || a==n2 || b==n1 || b==n2)
            System.out.println("You won $20,000");
        else
            System.out.println("You lose");
    }
}

public class lottery {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

//        System.out.println(a);
//        System.out.println(b);
        System.out.println("Enter two digits one by one");
        int c=scr.nextInt();
        int d=scr.nextInt();
       Check ch = new Check();
       ch.check(c,d);
    }
}
