package thread.thread_0530;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-30
 * Time: 09:22
 */
/*
信号量演示
 */
public class ThreadDemo98 {
    public static void main(String[] args) {
        //创建信号量
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"到达停车场");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"进入停车场");
                        int num  = 1+new Random().nextInt(5);
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"离开停车场。。。。。");
                semaphore.release();
            }
        });
    }
}
