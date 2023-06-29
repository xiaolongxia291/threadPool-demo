package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" mythread...");
        return "success";
    }

    public static void main(String[] args) {
        MyCallable myCallable=new MyCallable();
        FutureTask<String> futureTask=new FutureTask<String>(myCallable);
        new Thread(futureTask).start();

        //获取执行结果
        try {
            String str=futureTask.get();//会调用call()的执行结果
            System.out.println("执行结果："+str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
