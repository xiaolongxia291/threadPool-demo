package thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" mythread...");
    }

    public static void main(String[] args) {
        MyRunnable r=new MyRunnable();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
