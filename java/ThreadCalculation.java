
class SquareThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Square of " + i + " = " + (i * i));
                Thread.sleep(10000); 
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class CubeThread implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Cube of " + i + " = " + (i * i * i));
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ThreadCalculation {
    public static void main(String[] args) {

        SquareThread t1 = new SquareThread();

        Thread t2 = new Thread(new CubeThread());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Calculations Complete!");
    }
}