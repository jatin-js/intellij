import static java.lang.Thread.sleep;

public class Threads{
    static int n;
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n = (int) (Math.random() * 11);
                Thread t1 = new Thread(new Thread2());
                t1.start();
                Thread t2 = new Thread(new Thread3());
                t2.start();
            }
        }
    }
   static class Thread2 implements Runnable{
        @Override
        public void run(){
            if(n%2==0) System.out.println("Square :"+n*n);
        }
    }
    static class Thread3 implements Runnable{
        @Override
        public void run(){
            if(n%2==1) System.out.println("Cube :"+n*n*n);
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new Thread1();
        Thread t1 = new Thread(r1);

        t1.start();


        }
    }

