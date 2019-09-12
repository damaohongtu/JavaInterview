package JavaDemo.JUCTest;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author MaoTian
 * @Classname ConcurrentContainersTest
 * @Description 并发容器相关
 * @Date 上午9:37 2019/8/10
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ConcurrentContainersTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        CopyOnWriteArraySet copyOnWriteArraySet=new CopyOnWriteArraySet();

        ConcurrentSkipListSet concurrentSkipListSet=new ConcurrentSkipListSet();
        ConcurrentHashMap concurrentHashMap;
        ConcurrentSkipListMap concurrentSkipListMap;

        ArrayBlockingQueue arrayBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        ConcurrentLinkedDeque concurrentLinkedDeque;
        ReentrantLock reentrantLock;
        Future future;
        FutureTask futureTask;
        ThreadPoolExecutor threadPoolExecutor;
    }
}
