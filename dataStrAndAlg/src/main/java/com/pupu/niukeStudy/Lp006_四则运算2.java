package com.pupu.niukeStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * 示例1
 * 输入： 3+2*{1+2*[-4/(8-6)+7]}
 * 输出： 25
 * <p>
 * 思想：
 *
 * @author lp
 * @since 2021/6/3 20:58:51
 */
public class Lp006_四则运算2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expr;

        while ((expr = reader.readLine()) != null) {
            // 1. List 存放后缀表达式中的数值
            List<String> list = new ArrayList<>();

            // 2. 定义操作符栈stack，用于存放操作符 + - * / (
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < expr.length(); i++) {
                char c = expr.charAt(i);
                if (isNum(c)) {
                    int start = i;
                    if (i == expr.length() - 1) {
                        i++;
                    } else {
                        while (isNum(expr.charAt(++i))) {
                        }
                    }
                    list.add(expr.substring(start, i));
                    i--;
                } else if (c == '(' || c == '[' || c == '{') {
                    // 字符为左括号则入栈
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    //  一直出栈直到遇到左括号
                    while (stack.peek() != '(' && stack.peek() != '[' && stack.peek() != '{') {
                        // 当栈顶不为左括号时，将此操作符添加到LIST中
                        list.add(String.valueOf(stack.pop()));
                    }
                    stack.pop();
                } else if (c == '-') {
                    if ((i != 0 &&
                            (isNum(expr.charAt(i - 1)) && isNum(expr.charAt(i + 1)))) ||
                            (expr.charAt(i - 1) == ')' || expr.charAt(i - 1) == ']' || expr.charAt(i - 1) == '}') ||
                            (expr.charAt(i + 1) == '(' || expr.charAt(i + 1) == '[') ||
                            expr.charAt(i + 1) == '{') {

                        // 减号
                        while (!greaterThan(c, stack)) {
                            list.add(String.valueOf(stack.pop()));
                        }
                        stack.push(c);
                    } else {
                        // 负号
                        int start = i;
                        while (isNum(expr.charAt(++i))) {
                        }
                        list.add(expr.substring(start, i));
                        i--;
                    }
                } else if (c == '+') {
                    while (!greaterThan(c, stack)) {
                        list.add(String.valueOf(stack.pop()));
                    }
                    stack.push(c);
                } else if (c == '*' || c == '/') {

                    while (!greaterThan(c, stack)) {
                        list.add(String.valueOf(stack.pop()));
                    }
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()) {
                list.add(String.valueOf(stack.pop()));
            }

            // 计算后缀表达式
            int res = calculate(list);
            System.out.println(res);
        }
    }

    // 判断字符是否是数字
    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    // 比较当前运算符与栈顶运算符的优先级
    public static boolean greaterThan(char c, Stack<Character> stack) {
        if (stack.isEmpty()) {
            return true;
        } else {
            char c1 = stack.peek();
            if (c == '*' || c == '/') {
                return !(c1 == '*' || c1 == '/');
            } else {
                return c1 == '(' || c1 == '{' || c1 == '[';
            }
        }
    }

    public static int calculate(List<String> list) {
        // 定义数字栈，存放后缀表达式计算过程中的值
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int n1;
            int n2;
            switch (s) {
                case "*":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n1 * n2);
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
