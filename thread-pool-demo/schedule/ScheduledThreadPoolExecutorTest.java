package schedule;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
    public static final SimpleDateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        //创建多个TimerTask
        TimerTask timerTask1=new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务1："+FORMAT.format(new Date()));
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        TimerTask timerTask2=new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务2："+FORMAT.format(new Date()));
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        //创建ScheduledThreadPoolExecutor执行周期定时任务
        System.out.println("现在是："+FORMAT.format(new Date()));
        ScheduledThreadPoolExecutor pool=new ScheduledThreadPoolExecutor(2);
        pool.scheduleAtFixedRate(timerTask1, 0, 1000, TimeUnit.MILLISECONDS);
        pool.scheduleAtFixedRate(timerTask2, 0, 2000, TimeUnit.MILLISECONDS);
    }

    
    
}

