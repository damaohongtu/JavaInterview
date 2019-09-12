package BiShi.XieCheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @Author MaoTian
 * @Classname XieCheng_01
 * @Description TODO
 * @Date 下午6:51 2019/9/4
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class XieCheng_01 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in=new Scanner(new File("/home/mao/workspace/java/src/BiShi/XieCheng/test1"));
        //Scanner sc=new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        head= partition(head,m+1);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
