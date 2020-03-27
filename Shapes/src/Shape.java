import java.util.Scanner;

abstract class Shape
{
    Scanner scr = new Scanner(System.in);

    int a,b;

    abstract public double area();
}

class Rectangle extends Shape
{

//    @Override
    public double area()
    {
        System.out.println("Enter length and width");
        a = scr.nextInt();
        b = scr.nextInt();
        return a*b;
    }
}

class Circle extends Shape
{

    double pi = 3.14;

//    @Override
    public double area()
    {
        System.out.println("Enter radius");
        a = scr.nextInt();
        return pi*a*a;
    }
}

class Triangle extends Shape{

    public double area(){
        System.out.println("Enter base and height");
        a = scr.nextInt();
        b = scr.nextInt();
        return a*b/2.0;
    }
}

class Main
{
    public static void main (String[] args)
    {
        Scanner scr = new Scanner(System.in);

        boolean b = true;

        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        Circle c = new Circle();

        while(b){
            System.out.println("1 for rectangle");
            System.out.println("2 for triangle");
            System.out.println("3 for circle");
            int n = scr.nextInt();
            switch (n){
                case 1:
                    System.out.println(r.area());
                break;
                case 2:
                    System.out.println(t.area());
                break;
                case 3:
                    System.out.println(c.area());
                break;
                case 4:
                    b = false;
                break;
                default:
                    System.out.println("Wrong option");

            }
        }

    }
}

