package JavaBasic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CountDownLatchExample
 * @Description TODO
 * @Date 19-7-7 上午8:49
 * @Created by mao<tianmao818@qq.com>
 */
public class CountDownLatchExample {
    // 请求的数量
    private static final int threadCount = 5500;

    public static void main(String[] args) throws InterruptedException {


        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(5500);


        long startTime1 = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    test("test1",threadnum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();// 表示一个请求已经被完成
                }

            });
        }
        countDownLatch.await();
        long endTime1 = System.currentTimeMillis();
        System.out.println("finish:"+(endTime1-startTime1));
        threadPool.shutdown();


        // 不使用线程池
        long startTime2=System.currentTimeMillis();
        final CountDownLatch countDownLatch2 = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
//            new Thread(){
//                public void run(){
//                    try {
//                        test("test2",threadnum);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    } finally {
//                        countDownLatch2.countDown();
//                    }
//                }
//            }.start();

            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                test("test2",threadnum);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } finally {
                                countDownLatch2.countDown();
                            }
                        }
                    }
            ).start();

        }

        countDownLatch2.await();

        long endTime2=System.currentTimeMillis();
        System.out.println("finish:"+(endTime2-startTime2));

    }

    public static void test(String s,int threadnum) throws InterruptedException {
        Thread.sleep(10000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum+","+s);
        Thread.sleep(10000);// 模拟请求的耗时操作
    }
}
