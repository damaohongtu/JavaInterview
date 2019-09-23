package CommonProblems.ArrayProblems;

/**
 * @Author MaoTian
 * @Classname CycQueue
 * @Description 循环队列
 * @Date 上午9:46 2019/9/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class CycQueue<T> {
    private int maxsize;
    private Object[] arr;
    private int front;
    private int tail;

    public CycQueue(int maxsize) {
        this.maxsize = maxsize;
        this.arr =new Object[maxsize];
        this.front = 0;
        this.tail = 0;
    }

    public boolean isEmpty(){
        if (front==tail){
            return true;
        }else {
            return false;
        }
    }

    public CycQueue destroy(){
        arr=null;
        front=tail=0;
        return this;
    }

    public CycQueue clear(){

        front=tail=0;
        for (int i = 0; i <maxsize ; i++) {
            arr[i]=null;
        }
        return this;
    }

    public int size(){
        return (tail-front+maxsize)%maxsize;
    }

    public Object head(){
        return arr[front];
    }

    public boolean add(Object e){
        if((tail+1)%maxsize==front){
            return false;
        }

        tail=(tail+1)%maxsize;
        arr[tail]=e;
        return true;
    }

    public Object pop(){
        if(front==tail){
            return null;
        }
        T e=(T)arr[front];
        front=(front+1)%maxsize;
        return e;
    }

    public static void main(String[] args) {
        CycQueue c=new CycQueue(6);
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        System.out.println(c.add(7));
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.add(7));
        System.out.println(c.add(8));
        for (int i = 0; i <6 ; i++) {
            System.out.print(c.arr[i]+" ");
        }
    }

}
