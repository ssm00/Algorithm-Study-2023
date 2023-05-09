package week6.Seo_Sumin;

import java.util.Stack;

/**
 * 프로그래머스 그리디 큰 수 만들기
 */

public class Ex03 {
    public String solution(String number, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int last = 0;
        int temp = 0;
        int cnt = number.length()-k;
        for (int i = 0; i < number.length() - k; i++) {
            int max = -1;
            for (int j = last; j <= number.length()-cnt; j++) {
                if (last == number.length()) {
                    return stringBuffer.toString();
                }
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    last = j + 1;
                }
            }
            stringBuffer.append(max);
            cnt--;
        }
        return stringBuffer.toString();
    }

    public String solution1(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i+1 < sb.length() && k>0; i++) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i=-1;
                k--;
            }
        }
        if(k!=0)
            sb.delete(sb.length()-k, sb.length());
        return sb.toString();
    }

    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i); //1924에 직접 접근
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) { //stack이 비어있지 않고 스택에 있는게 현재위치의 수보다 작고 k-- 한게 0보다 크면
                stack.pop(); //맨위에를 뽑는다.
            }
            //위의 상황이 아니라면 stack에 넣는다.
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Ex03 ex03 = new Ex03();
        String i1 = "4177252841";
        String i2 = "1924";
//        System.out.println("ex03.solution(i1,4) = " + ex03.solution(i1, 4));
//        System.out.println("ex03.solution1(i1,4) = " + ex03.solution1(i1, 4));
//        System.out.println("ex03.solution(i1,4) = " + ex03.solution(i2, 2));
//        System.out.println("ex03.solution1(i1,4) = " + ex03.solution1(i2, 2));
        System.out.println("ex03.solution1(i1,4) = " + ex03.solution2("41231723", 5));
    }
}
