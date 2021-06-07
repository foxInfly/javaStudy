package com.pupu.niukeStudy;

import java.io.*;
/**
 * 给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 * 示例1
 * 输入： 400+5
 * 输出： 405
 *
 * @author lp
 * @since 2021/6/7 9:38:16
 */
public class Lp008_表达式求值 {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        System.out.println(new ExprDemo().expr(in));
    }

    public static class ExprDemo {
        public char lastsign1 = 0, lastsign2 = 0;
        public int temp1 = 0, temp2 = 0;
        private static final char tempchar = 0;

        public int expr(InputStream in) throws IOException {
            int result = 0;
            char c;
            a: while((c = (char)in.read()) != '\n') {
                switch (c) {
                    case ')': break a;
                    case '(': temp2 = new ExprDemo().expr(in); break;
                    case '+':
                    case '-':
                        jisuan1(tempchar);
                        result = jisuan2(c, result);
                        break;
                    case '*':
                    case '/':
                        jisuan1(c);
                        break;
                    default: temp2 = temp2 * 10 + c - '0'; break;
                }
            }
            jisuan1(tempchar);
            result = jisuan2(tempchar, result);
            return result;
        }

        private void jisuan1(char c) {
            switch (lastsign2) {
                case 0: temp1 = temp2; break;
                case '*': temp1 *= temp2; break;
                case '/': temp1 /= temp2; break;
                default: break;
            }
            temp2 = 0;
            lastsign2 = c;
        }

        private int jisuan2(char c, int result) {
            switch (lastsign1) {
                case 0: result = temp1; break;
                case '-': result -= temp1; break;
                case '+': result += temp1; break;
                default: break;
            }
            temp1 = 0;
            lastsign1 = c;
            return result;
        }
    }


}
