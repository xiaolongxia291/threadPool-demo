import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecuteTest {
    public static void main(String[] args) {
        //创建一个线程池
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        pool.execute(new Task1());
        pool.execute(new Task2());
        pool.execute(new Task3());
        pool.shutdown();
    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println("正在执行Task1");
    }
}

class Task2 implements Runnable{
    @Override
    public void run() {
        System.out.println("正在执行Task2");
    }
}

class Task3 implements Runnable{
    @Override
    public void run() {
        System.out.println("正在执行Task3");
    }
}