package CommonProblems.StackProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author MaoTian
 * @Classname CalculatorDemo
 * @Description 表达式的计算，使用两个栈建立后缀表达式，通过后缀表达式进行求值0
 * 操作符是以中缀形式处于操作数的中间（例：3 + 4）。
 * 前缀表达式（例：+ 3 4）
 * 后缀表达式（例：3 4 +）
 * @Date 下午3:25 2019/9/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */


public class CalculatorDemo {

    public static void main(String[] args) throws FileNotFoundException {

        //Scanner sc=new Scanner(System.in);
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/CommonProblems/StackProblems/CalculatorDemo"));

        while(sc.hasNext()){
            String s=sc.nextLine();
            s=s.replaceAll("\\{", "(");
            s=s.replaceAll("\\[", "(");
            s=s.replaceAll("\\}", ")");
            s=s.replaceAll("\\]", ")");

            //保存操作数和符号
            ArrayList<String> list=new ArrayList<>();

            //预处理
            char[] c=s.toCharArray();
            int i=0;
            while(i<c.length){
                int k=0;
                while(k+i<c.length && c[i+k]>='0' && c[i+k]<='9'){
                    k++;
                }
                if(k!=0){
                    //添加数字
                    list.add(String.copyValueOf(c, i, k));
                    i=i+k;
                }
                else{
                    //添加符号：括号和操作符号
                    list.add(String.copyValueOf(c, i, 1));
                    i++;
                }
            }

            //一个+-*/对应着两个数字
            ArrayList<String> list1=new ArrayList<>();
            for(int j=0; j<list.size(); j++){

                //对负数-N进行特殊的处理，改为0-N
                if(list.get(j).equals("-")){
                    if(j==0){
                        list1.add("0");
                    }
                    else{
                        if(list.get(j-1).equals("(")){
                            list1.add("0");
                        }
                    }
                }

                list1.add(list.get(j));
            }

            System.out.println("-----------------------------------------------");
            for (String cc:list1){
                System.out.print(cc+" ");
            }
            System.out.println();
            System.out.println("-----------------------------------------------");

            System.out.println(computeNum(list1));
        }

    }

    //获取后缀表达式
    //将中缀表达式（即标准的表达式）转换为后缀表达式:
    // 1 + 2 * 3 + ( 4 * 5 + 6 ) * 7 转换成 1 2 3 * + 4 5 * 6 + 7 * +
    /*
    首先，读入‘1’，并送到输出，然后‘+’被读入并压入栈中。接下来‘2’读入并送到输出，此时状态如下：
    栈：+
    输出：1 2

    接下来读入‘*’，由于优先级比栈顶元素‘+’大（原则3），因此被压入栈中，接着读入‘3’，并送到输出：
    栈：+ *
    输出：1 2 3

    然后读入‘+’，由于此时栈顶元素为‘*’，优先级比‘+’大，因此将‘*’弹出，弹出后原来的‘+’变为栈顶元素，由于‘+’的优先级和当前读入的‘+’优先级相等，因此也被弹出（原则3），最后将读入的‘+’压入栈中，因此状态如下：
    栈：+
    输出：1 2 3 * +

    下一个读入的符号‘（’，由于具有最高优先级，因此将其放入栈中，然后读入‘4’：
    栈：+ （
    输出： 1 2 3 * + 4

    继续读入，此时读入‘*’，除非处理‘）’，否则‘（’绝不会弹出，因此‘*’被压入栈中，接下来读入‘5’：
    栈：+ （*
    输出：1 2 3 * + 4 5

    往后读入的符号是‘+’，将‘*’弹出并输出。然后将‘+’压入栈中，接着读入‘6’：
    栈：+ （ +
    输出：1 2 3 * + 4 5 * 6

    现在读入‘）’，因此弹出栈中元素直到遇到‘（’：
    栈：+
    输出：1 2 3 * + 4 5 * 6 +

    下一个有读入‘*’，被压入栈中，然后读入‘7’：
    栈：+ *
    输出：1 2 3 * + 4 5 * 6 + 7

    现在输入为空，弹出所有栈中元素
    栈：空
    输出：1 2 3 * + 4 5 * 6 + 7 * +
    * */
    public static String[] getPostfixExpression(ArrayList<String> list){
        //使用两个栈
        Stack<String> s1=new Stack<>();
        Stack<String> s2=new Stack<>();
        int i=0;

        while(i<list.size()){

            //括号的优先级最高
            if(list.get(i).equals("(")){
                s2.add(list.get(i));
                i++;
                continue;
            }
            //加减
            if(list.get(i).equals("+") || list.get(i).equals("-")){
                while(!s2.isEmpty() && !s2.peek().equals("(")){
                    s1.add(s2.pop());
                }
                s2.add(list.get(i));
                i++;
                continue;
            }
            //乘除
            if(list.get(i).equals("*") || list.get(i).equals("/")){
                while(!s2.isEmpty() && (s2.peek().equals("*") || s2.peek().equals("/"))){
                    s1.add(s2.pop());
                }
                s2.add(list.get(i));
                i++;
                continue;
            }
            if(list.get(i).equals(")")){
                while(!s2.isEmpty() && !s2.peek().equals("(")){
                    s1.add(s2.pop());
                }
                s2.pop();
                i++;
                continue;
            }
            s1.add(list.get(i));
            i++;
        }
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }

        String[] c=new String[s1.size()];
        for(int j=c.length-1; j>=0; j--){
            c[j]=s1.pop();
        }

        System.out.println("-----------------------------------------------");
        for (String cc:c){
            System.out.print(cc+" ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------");

        return c;
    }


    //通过后缀表达式求值,从栈中取元素，进行计算，计算完后入栈
    public static int computeNum(ArrayList<String> list){

        //获得后缀表达式
        String[] c=getPostfixExpression(list);
        //保存计算的结果
        Stack<Integer> s=new Stack<>();
        for(int i=0; i<c.length; i++){
            int t1, t2;
            if(c[i].equals("+")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2+t1);
                continue;
            }
            if(c[i].equals("-")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2-t1);
                continue;
            }
            if(c[i].equals("*")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2*t1);
                continue;
            }
            if(c[i].equals("/")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2/t1);
                continue;
            }
            //数字入栈
            s.add(Integer.parseInt(c[i]));
        }
        return s.pop();
    }
}