package week2.Seo_Sumin;

import java.util.Stack;

/**
 * 프로그래머스 올바른 괄호
 */

public class Ex03 {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(st.isEmpty()){
                    return false;
                }else if(st.peek() == '('){
                    st.pop();
                }else {
                    st.push(s.charAt(i));
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()(";
        Ex03 t = new Ex03();
        System.out.println("t.solution(s) = " + t.solution(s));
    }
}
