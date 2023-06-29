import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SubmitTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        //创建一个线程池
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        //submit一个callable任务
        Future<String> future=pool.submit(new Task(1));
        //获取callable任务执行结果
        while(!future.isDone()){
            System.out.println("获取执行结果："+future.get());
        }
        pool.shutdown();
    }
}

class Task implements Callable<String>{
    private int id;
    public Task(int id){
        this.id=id;
    }

    @Override
    public String call() {
        System.out.println("正在执行Task id:"+id);
        return "success";
    }
}