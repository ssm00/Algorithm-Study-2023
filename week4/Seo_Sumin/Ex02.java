package week4.Seo_Sumin;

import java.util.ArrayList;

/**
 * 프로그래머스 가장 큰 수
 * 단위로 비교시 그냥 String 통째로 비교가능
 */


public class Ex02 {

    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for (Integer i : numbers) {
             list.add(String.valueOf(i));
        }

        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));
        for (String s : list) {
             answer += s;
        }
        if (answer.charAt(0)=='0') {
            return "0";
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 30, 34, 5, 9};
        Ex02 ex02 = new Ex02();
        System.out.println(ex02.solution(arr1));
    }
}
