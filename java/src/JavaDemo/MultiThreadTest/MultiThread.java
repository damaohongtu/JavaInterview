package JavaDemo.MultiThreadTest;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author MaoTian
 * @Classname MultiThread
 * @Description 查看有哪些线程
 *
 * [5] Monitor Ctrl-Break
 * [4] Signal Dispatcher
 * [3] Finalizer
 * [2] Reference Handler
 * [1] main
 *
 * @Date 下午9:23 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
