package schedule;

import java.text.SimpleDateFormat;
import java.util.*;

public class TimerTest {
    public static final SimpleDateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        //创建一个TimerTask
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务："+FORMAT.format(new Date()));
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        //创建Timer执行周期定时任务
        System.out.println("现在是："+FORMAT.format(new Date()));
        Timer timer=new Timer();
        timer.schedule(timerTask,new Date(), 2000);
        
    }
    
}
