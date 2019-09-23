package CommonProblems.listdemo;

/**
 * @Author MaoTian
 * @Classname FanZhuanLianBiao
 * @Description 翻转链表，还可以使用递归的方式，使用迭代的话使用三个节点进行
 * @Date 上午10:23 2019/8/11
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class Node{
    int value;
    Node next;
    public Node(int value,Node next){
        this.value=value;
        this.next=next;
    }
}
public class ReverseList {
    public static void main(String[] args) {
        Node head=new Node(1,null);
        Node tmp=head;
        for(int i=2;i<6;i++){
            Node node=new Node(i,null);
            tmp.next=node;
            tmp=tmp.next;
        }

        Node pNode=head;
        Node pre=null;
        Node newHead=null;
        while(pNode!=null){
            Node pNext=pNode.next;
            if(pNext==null){
                newHead=pNode;
            }
            pNode.next=pre;
            pre=pNode;
            pNode=pNext;
        }
        while(newHead!=null){
            System.out.println(newHead.value);
            newHead=newHead.next;
        }
    }
}
