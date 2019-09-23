package BiShi.WeBank;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Test2 {
    /* 临时保存路径节点的栈 */
    public static Stack<Node> stack = new Stack<Node>();
    /* 存储路径的集合 */
    public static ArrayList<Object[]> sers = new ArrayList<Object[]>();

    /* 判断节点是否在栈中 */
    public static boolean isNodeInStack(Node node) {
        Iterator<Node> it = stack.iterator();
        while (it.hasNext()) {
            Node node1 = (Node) it.next();
            if (node == node1)
                return true;
        }
        return false;
    }

    /* 此时栈中的节点组成一条所求路径，转储并打印输出 */
    public static void showAndSavePath() {
        Object[] o = stack.toArray();
        for (int i = 0; i < o.length; i++) {
            Node nNode = (Node) o[i];

            if (i < (o.length - 1))
                System.out.print(nNode.getName() + "->");
            else
                System.out.print(nNode.getName());
        }
        sers.add(o); /* 转储 */
        System.out.println("\n");
    }

    /*
     * 寻找路径的方法 cNode: 当前的起始节点currentNode pNode: 当前起始节点的上一节点previousNode sNode:
     * 最初的起始节点startNode eNode: 终点endNode
     */
    public static boolean getPaths(Node cNode, Node pNode, Node sNode, Node eNode) {
        Node nNode = null;
        /* 如果符合条件判断说明出现环路，不能再顺着该路径继续寻路，返回false */
        if (cNode != null && pNode != null && cNode == pNode)
            return false;

        if (cNode != null) {
            int i = 0;
            /* 起始节点入栈 */
            stack.push(cNode);
            /* 如果该起始节点就是终点，说明找到一条路径 */
            if (cNode == eNode) {
                /* 转储并打印输出该路径，返回true */
                showAndSavePath();
                return true;
            }
            /* 如果不是,继续寻路 */
            else {
                /*
                 * 从与当前起始节点cNode有连接关系的节点集中按顺序遍历得到一个节点 作为下一次递归寻路时的起始节点
                 */
                nNode = cNode.getRelationNodes().get(i);
                while (nNode != null) {
                    /*
                     * 如果nNode是最初的起始节点或者nNode就是cNode的上一节点或者nNode已经在栈中 ， 说明产生环路
                     * ，应重新在与当前起始节点有连接关系的节点集中寻找nNode
                     */
                    if (pNode != null && (nNode == sNode || nNode == pNode || isNodeInStack(nNode))) {
                        i++;
                        if (i >= cNode.getRelationNodes().size())
                            nNode = null;
                        else
                            nNode = cNode.getRelationNodes().get(i);
                        continue;
                    }
                    /* 以nNode为新的起始节点，当前起始节点cNode为上一节点，递归调用寻路方法 */
                    if (getPaths(nNode, cNode, sNode, eNode))/* 递归调用 */
                    {
                        /* 如果找到一条路径，则弹出栈顶节点 */
                        stack.pop();
                    }
                    /* 继续在与cNode有连接关系的节点集中测试nNode */
                    i++;
                    if (i >= cNode.getRelationNodes().size())
                        nNode = null;
                    else
                        nNode = cNode.getRelationNodes().get(i);
                }
                /*
                 * 当遍历完所有与cNode有连接关系的节点后， 说明在以cNode为起始节点到终点的路径已经全部找到
                 */
                stack.pop();
                return false;
            }
        } else
            return false;
    }

    public static void main(String[] args) {
        /* 定义节点关系 */
        String nodeRalation[][] = { { "0" }, // 0
                { "2" }, // 1
                { "1", "3" }, // 2
                { "2", "4", "9" }, // 3
                { "3", "5" }, // 4
                { "4" }, // 5
                { "9" }, // 6
                { "10", "8" }, // 7
                { "7", "11" }, // 8
                { "3", "6", "10" }, // 9
                { "9", "7", "11" }, // 10
                { "10", "8" } // 11
        };

        /* 定义节点数组 */
        Node[] node = new Node[nodeRalation.length];

        for (int i = 0; i < nodeRalation.length; i++) {
            node[i] = new Node();
            node[i].setName("node" + i);
        }

        /* 定义与节点相关联的节点集合 */
        for (int i = 0; i < nodeRalation.length; i++) {
            ArrayList<Node> List = new ArrayList<Node>();

            for (int j = 0; j < nodeRalation[i].length; j++) {
                for (int z = 0; z < nodeRalation.length; z++) {
                    if (node[z].getName().equals("node" + nodeRalation[i][j])) {
                        List.add(node[z]);
                        break;
                    }
                }
            }
            node[i].setRelationNodes(List);
            List = null; // 释放内存
        }

        /* 开始搜索所有路径 */
        getPaths(node[1], null, null, node[8]);
    }
}

