package CommonProblems.DesignPattern;

/**
 * @Author MaoTian
 * @Classname ChainOfResponsibility
 * @Description 责任链模式
 * @Date 上午10:29 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */


/**
 * 抽象处理者
 */
abstract class Player {

    //具体的传花人
    private  Player successor;
    //传入下一个具体的传花人
    protected void setSuccessor(Player successor){
        this.successor=successor;
    }
    //传递的过程
    public abstract  void handle(int i);
    //传递給下一个
    public void next(int index){
        if (successor!=null) {
            successor.handle(index);
        }else {
            System.out.println("游戏结束！");
        }
    }
}

/**
 * 具体处理者，传花人
 */
class PlayerA extends Player {

    //构造方法,传入下一个传花人
    public PlayerA(Player successor) {
        this.setSuccessor(successor);
    }

    //传花的过程
    @Override
    public void handle(int i) {
        if (i==1){
            System.out.println("PlayerA 喝酒！");
        }else {
            System.out.println("PlayerA 向下传花！");
            next(i);
        }
    }
}


/**
 * 具体处理者，传花人
 */
class PlayerB extends Player {
    //构造方法,传入下一个传花人
    public PlayerB(Player successor) {
        this.setSuccessor(successor);
    }
    //传花的过程
    @Override
    public void handle(int i) {
        if (i==2){
            System.out.println("PlayerB 喝酒！");
        }else {
            System.out.println("PlayerB 向下传花！");
            next(i);
        }
    }
}


/**
 * 具体处理者，传花人
 */
class PlayerC extends Player {
    //构造方法,传入下一个传花人
    public PlayerC(Player successor) {
        this.setSuccessor(successor);
    }
    //传花的过程
    @Override
    public void handle(int i) {
        if (i==3){
            System.out.println("PlayerC 喝酒！");
        }else {
            System.out.println("PlayerC 向下传花！");
            next(i);
        }
    }
}

/**
 * 具体处理者，传花人
 */
class PlayerD extends Player {

    //构造方法,传入下一个传花人
    public PlayerD(Player successor) {
        this.setSuccessor(successor);
    }

    //传花的过程
    @Override
    public void handle(int i) {
        if (i==4){
            System.out.println("PlayerD 喝酒！");
        }else {
            System.out.println("PlayerD 向下传花！");
            next(i);
        }
    }
}

public class ChainOfResponsibilityDemo {
    public static void main(String args[]){
        //创建一个链
        PlayerD playerD=new PlayerD(null);
        PlayerC playerC=new PlayerC(playerD);
        PlayerB playerB=new PlayerB(playerC);
        PlayerA playerA=new PlayerA(playerB);

        //击鼓三次下停下来
        playerA.handle(1);

    }
}
