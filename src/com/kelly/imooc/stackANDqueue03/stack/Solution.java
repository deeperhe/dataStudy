package com.kelly.imooc.stackANDqueue03.stack;
import java.util.Stack;

/**
 * 题目：给定一个只包含'(',')','{','}','[',']'的字符串，判断字符串是否有效
 * 要求：括号必须以正确的顺序关闭，'()'是有效，但是'( ]'是无效字符串
 * 一旦匹配成功，相应的【栈顶元素就出栈啦】
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 查看字符串中的第i个元素
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    // 栈是空的话  字符串肯定是失败的
                    return false;
                // 所以我们来看看栈顶的元素
                char popChar = stack.pop();
                // 那就肯定是右括号系列啦  然后在和栈顶元素进行比较
                if (c == ')' && popChar != '(')
                    return false;
                if (c == ']' && popChar != '[')
                    return false;
                if (c == '}' && popChar != '{')
                    return false;
            }
        }
        // 只有栈中为空的时候，才代表我们的字符串匹配成功啦
        return stack.isEmpty();
    }
}
