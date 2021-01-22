package com.pupu.structure.stack;

import lombok.Data;

import java.util.Scanner;

/**数组模拟栈
 * @author : lipu
 * @since : 2020-02-20 16:39
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //创建一个栈
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:向栈添加数据(入栈)");
            System.out.println("pop:从栈取数据(出栈)");
            System.out.print("请输入您的选择:");
            key = scanner.next();

            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                case "push":
                    System.out.print("请输入一个数：");
                    arrayStack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        int value = arrayStack.pop();
                        System.out.println("出栈的数据为："+value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

//定义一个ArrayStack表示栈
@Data
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟的栈
    private int top = -1;//栈顶，初始化为-1
    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
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
            System.out.println("demo02_stack["+i+"]="+stack[i]);
        }
    }
}