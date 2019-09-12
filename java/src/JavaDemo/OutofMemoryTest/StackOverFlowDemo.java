package JavaDemo.OutofMemoryTest;

/**
 * @Author MaoTian
 * @Classname StackOverFlow
 * @Description TODO
 * @Date 下午11:09 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class StackOverFlowDemo {
    public int add(int a,int b){
        return add(add(a,b),add(a,b));
    }
    public static void main(String[] args) {
        StackOverFlowDemo stackOverFlowDemo=new StackOverFlowDemo();
        stackOverFlowDemo.add(1,2);
    }
}
