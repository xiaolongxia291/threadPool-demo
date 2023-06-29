package thread;

public class Mythread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" mythread...");
    }

    public static void main(String[] args) {
        Thread t1=new Mythread();
        Thread t2=new Mythread();
        Thread t3=new Mythread();
        t1.start();
        t2.start();
        t3.start();
    }
}
