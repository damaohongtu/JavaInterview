package CommonProblems.ListProblems;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @Author MaoTian
 * @Classname XieCheng_01
 * @Description
 * 9 -> 0 -> 4 -> 5 -> 1 -> null
 * afterHead -> 9 -> 4 -> 5
 * (-1)                  (after)
 * beforeHead -> 0 -> 1
 * (-1)              (before)
 * 使用双指针，改变指针的指向关系，将链表分割为两个部分，一个beforeHead是比m小的，一个afterHead是比m大的
 * 将两者合并就是最终的结果！
 * @Date 下午6:51 2019/9/4
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ListPartition {


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
