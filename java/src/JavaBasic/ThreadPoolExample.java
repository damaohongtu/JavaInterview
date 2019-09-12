package JavaBasic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Classname ThreadPoolExample
 * @Description 线程池的几种写法
 * 比较线程池之间的区别
 * 比较使用线程池和不使用线程池在资源和时间上的消耗
 * @Date 19-7-7 上午8:55
 * @Created by mao<tianmao818@qq.com>
 */

public class ThreadPoolExample {
    private static final int threadCount = 550;
    public static void main(String[] args)throws InterruptedException{


        ExecutorService threadPool= Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    test(threadnum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();// 表示一个请求已经被完成
                }

            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
