package com.pupu.structure.stack;

import lombok.Data;

/**计算器
 * @author : lipu
 * @since : 2020-02-20 19:32
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*3-2+4-5";
        //创建两个栈，数据和符号
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch
        String keepNum = "";//用于拼接
        //开始while循环的扫描expression
        while (true){
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做响应的处理
            if(operStack.isOper(ch)){
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数据栈中pop出两个数，
                    //再从符号栈中pop出一个符号，进行运算，将得到结果，入数据栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.pick())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //把运算的结果入数据栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        //如果当前的操作符优先级大于栈中的操作符，就直接入符号栈。
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接处理入栈
                    operStack.push(ch);
                }
            }else {//如果是数，则直接入数据栈
//                numStack.push(ch - 48);//ASCII表，字符1对应的十进制值是19
                //有可能是多位数，向后再取一位，是符号才入栈
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数据栈和符号栈中pop出相应的数和符号，并运行
        while (true){
            //如果符号栈为空，则计算到最后的结果，数据栈中只有一个数字【结果】
            if (operStack.isEmpty()) {break;}
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);//入栈
        }
        //将数据栈的最后数据，pop出，就是结果
        System.out.println("表达式："+expression+" = "+numStack.pop());
    }
}

//定义一个ArrayStack2表示栈
@Data
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟的栈
    private int top = -1;//栈顶，初始化为-1
    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //查询栈顶的值
    public int pick(){
        return stack[top];
    }


    //栈满
    public boolean isFull(){return top == maxSize -1;}
    //栈空
    public boolean isEmpty(){return top == -1;}

    //入栈
    public void push(int value){
        if (isFull()) {System.out.println("栈满");return;}
        top++;
        stack[top] = value;
    }

    //出栈,将栈顶的数据返回
    public int pop(){
        if (isEmpty()) {throw new RuntimeException("栈空，没有数据~~");}
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()) { System.out.println("栈空，没有数据~~");return;}
        for (int i = top; i >= 0 ; i--) {
            System.out.println("stack["+i+"]="+stack[i]);
        }
    }

    //运算符的优先级是程序员来确定，优先级使用数字表示，数字越大，则优先级越高
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;//嘉定目前的表达式只有+、-、*、/
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//计算结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
