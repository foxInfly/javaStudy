package com.pupu.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**逆波兰表达式==后缀表达式
 * @author : lipu
 * @since : 2020-02-20 23:07
 */
public class PolandNotation {
    public static void main(String[] args) {
        //逆波兰表达式：将"1+((2+3)*4)-5"转成"1 2 3 + 4 * + 5 1"；
        String expression = "1+((2+3)*4)-5";
        //1.将中缀表达式封装到一个list中
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式list："+infixExpressionList);

        //2.将中缀表达式封装的list转化成后缀表达式List
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式list："+suffixExpreesionList);
        String suffixExpression = "30 4 + 5 * 6 -";


        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);
        int calculate = calculate(suffixExpreesionList);
        System.out.println(expression+"="+calculate);
    }

    //2.将中缀表达式封装的list转化成后缀表达式
    public static List<String> parseSuffixExpreesionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还要逆序输出，因此比较麻烦，这里
        //我们不用tack<String>，直接用List<String>  s2
        ArrayList<String> s2 = new ArrayList<>();//存储中间结果的List2\

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号，则一次弹出s1栈顶的运算符，并亚茹s2，知道遇到左括号位置，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到(4,1)与s1中心的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈顶
                s1.push(item);
            }
        }

        //将s1中剩余的运算符一次弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;//注意因为存放到List，因此按顺序输出就是对应的逆波兰表达式；
    }


    //方法：将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放中缀表达式对应的内容
        ArrayList<String> ls = new ArrayList<>();
        int i = 0;//用于遍历中缀表达式字符串的指针
        String str ;//对多位数的拼接
        char c;//没遍历到一个字符，就放入到C
        do{
            //如果c是一个非数字，我需要加入到ls
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57) {
                ls.add(""+c);
                i++;//i后移
            }else {//如果是一个数，需要考虑多位数
                str = "";//先将str置""
                while (i < s.length() && (c=s.charAt(i)) >=48 && (c=s.charAt(i)) <=57){
                    str += c;//拼接
                    i++;//i后移
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }

    //讲一个逆波兰表达式，依次将数据和运算符放入到放入ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //实现逆波兰表达式的运算
    public static int calculate(List<String> ls){
        //创建一个栈，一个即可
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {//匹配的是多位数，入栈
                stack.push(item);
            }else {
                //pop出两个数，并与暗算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                }else if(item.equals("-")) {
                    res = num1 - num2;
                }else if(item.equals("*")) {
                    res = num1 * num2;
                }else if(item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类Operation可以返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
             default:
                 System.out.println("不存在该运算符");
                 break;
        }
        return result;
    }
}
