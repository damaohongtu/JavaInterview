package JavaBasic;

import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Classname ThreadSafety
 * @Description 线程安全的数据结构
 * @Date 19-6-1 下午7:31
 * @Created by mao<tianmao818@qq.com>
 */
public class ThreadSafety {
    //ReentrantLock
    private ConcurrentHashMap<Integer,Integer> concurrentHashMap=new ConcurrentHashMap<>();
    //synchronized
    private Hashtable<Integer,Integer> hashtable=new Hashtable<>();

    //ReentrantLock
    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue=new ConcurrentLinkedQueue<>();
    //ReentrantLock
    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList=new CopyOnWriteArrayList<>();
    //ReentrantLock
    private CopyOnWriteArraySet<Integer> copyOnWriteArraySet=new CopyOnWriteArraySet<>();


    //synchronized
    private Vector<Integer> vector=new Vector<>();
     //synchronized
    private StringBuffer stringBuffer=new StringBuffer();


    private String s;

    public static void main(String[] args){

    }

}
