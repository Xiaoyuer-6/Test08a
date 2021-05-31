package thread.thread_0530;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-30
 * Time: 09:51
 */
public class ThreadDemo99 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i <5 ; i++) {
            final int finalI = 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始起跑");
                    try {
                        Thread.sleep(finalI*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                    countDownLatch.countDown();
                }
            }).start();

        }
        countDownLatch.await();
    }
}
