package thread.thread_0530;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-30
 * Time: 10:02
 */
/*
循环屏障
 */
public class ThreadDemo100 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了CyclicBarrier中的runnable");
                for (int i = 0; i <11 ; i++) {
                    int finalI = 1;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(finalI*2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            //System.out.println();
                        }

                    });
                    //cyclicBarrier.await()

                }
            }
        });

    }
}
