package com.gp.linearList.stack.demo01_pracketcheck;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author lp
 * @since 2021/1/21 21:10:49
 */
public class BracketCheck {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("():"+isValid("()"));
        System.out.println("(){}[]:"+isValid("(){}[]"));
        System.out.println("(}:"+isValid("(}"));
        System.out.println("([)]:"+isValid("([)]"));
        System.out.println("{[]}:"+isValid("{[]}"));
        System.out.println("{[()]:"+isValid("{[()]"));
    }
}
