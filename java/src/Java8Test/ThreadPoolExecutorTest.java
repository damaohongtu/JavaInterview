package Java8Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadPoolExecutorTest
 * @Description TODO
 * @Date 19-7-13 下午4:15
 * @Created by mao<tianmao818@qq.com>
 */



public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 10; i++) {
            executor.execute(new MyTask(i));
            System.out.println("线程池中线程数："+executor.getPoolSize()+"，队列中等待执行的任务数："+
                    executor.getQueue().size()+"，已执行完的任务数："+executor.getCompletedTaskCount());
        }
    }
}

class MyTask implements Runnable {

    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("开始执行：任务 " + id);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕：任务 " + id);
    }

}
