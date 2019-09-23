package BiShi.WeBank;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_2
 * @Description TODO
 * @Date 下午4:49 2019/9/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */


import java.util.ArrayList;

/* 表示一个节点以及和这个节点相连的所有节点 */
class Node {
    public String name = null;
    public ArrayList<Node> relationNodes = new ArrayList<Node>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getRelationNodes() {
        return relationNodes;
    }

    public void setRelationNodes(ArrayList<Node> relationNodes) {
        this.relationNodes = relationNodes;
    }
}





public class Main_2 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/WeBank/main_2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n>=1000){
                System.out.println(3);
            }else{
                int res=1;

                for (int i = 1; i <=n ; i++) {
                    res=(res*i)%(1000000+3);
                }
                System.out.println(res);
            }

        }
    }
}
