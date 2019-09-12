package JavaDemo.AlgorithmDemo;

import java.util.HashMap;

/**
 * @Author MaoTian
 * @Classname LRUCache
 * @Description TODO
 * @Date 上午9:16 2019/8/23
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class LRUNode {
    String key;
    Object value;
    LRUNode prev;
    LRUNode next;
    public LRUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private HashMap<String, LRUNode> map;
    private int capacity;
    private LRUNode head;
    private LRUNode tail;

    public void set(String key, Object value) {
        LRUNode node = map.get(key);
        if (node != null) {
            //原来的节点
            node = map.get(key);
            node.value = value;
            remove(node, false);
        } else {
            //新节点
            node = new LRUNode(key, value);
            if (map.size() >= capacity) {
                // 每次容量不足时先删除最久未使用的元素
                remove(tail, true);
            }
            map.put(key, node);
        }
        // 将刚添加的元素设置为head
        setHead(node);
    }
    public Object get(String key) {
        LRUNode node = map.get(key);
        if (node != null) {
            // 将刚操作的元素放到head
            remove(node, false);
            setHead(node);
            return node.value;
        }
        return null;
    }
    private void setHead(LRUNode node) {
        // 建立双向指针
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }
    // 从链表中删除此Node，此时要注意该Node是head或者是tail的情形
    private void remove(LRUNode node, boolean flag) {
        //双向指针
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            //head
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            //tail
            tail = node.prev;
        }
        //删除
        node.next = null;
        node.prev = null;
        //容量不够的时候从map中删除
        if (flag) {
            map.remove(node.key);
        }
    }
    //构造函数
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<String, LRUNode>();
    }
}