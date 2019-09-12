package JianZhiOffer;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Classname LinkedListMerge
 * @Description 合并两个排序链表,Java Iterator的使用!
 * @Date 19-3-3 下午8:18
 * @Created by mao<tianmao818@qq.com>
 */
public class LinkedListMerge {
    public LinkedList<Integer> merge(List<Integer> list1,List<Integer> list2){
        ListIterator<Integer> head1=list1.listIterator();
        ListIterator<Integer> head2=list2.listIterator();
        LinkedList<Integer> result=new LinkedList<>();
        while(head1.hasNext() || head2.hasNext()){
            if(head1.hasNext() && head2.hasNext()){
                Integer val1=head1.next();
                Integer val2=head2.next();
                if(val1<val2){
                    result.add(val1);
                    head2.previous();
                }else {
                    result.add(val2);
                    head1.previous();
                }
            }else if(!head1.hasNext()){
                Integer val2=head2.next();
                result.add(val2);
            }else {
                Integer val1=head1.next();
                result.add(val1);
            }
        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> list1=new LinkedList<Integer>();
        List<Integer> list2=new LinkedList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);

        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);

        LinkedListMerge linkedListMerge=new LinkedListMerge();
        System.out.println(linkedListMerge.merge(list1,list2));

    }
}