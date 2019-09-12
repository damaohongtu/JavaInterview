package ALiBaBa;

import java.util.concurrent.*;

/**
 * @Author MaoTian
 * @Classname ThreadPoolExecutorDemo
 * @Description TODO
 * @Date 上午12:03 2019/8/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class TempThread implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "正在被执行");
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){

        }
    }
}

class TempThread2 implements Callable {
    @Override
    public String call(){
        System.out.println(Thread.currentThread().getName() + "正在被执行");
        return Thread.currentThread().getName();
    }
}



public class ThreadPoolExecutorDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<Runnable> bq=new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor ex=new ThreadPoolExecutor(3,6,1,TimeUnit.MILLISECONDS,bq);
        Runnable t1 = new TempThread();
        ex.execute(t1);

        TempThread2 t2=new TempThread2();

        FutureTask futureTask=new FutureTask(t2);
        ex.submit(futureTask);
        String s=futureTask.get().toString();
        System.out.println(s);

    }
}