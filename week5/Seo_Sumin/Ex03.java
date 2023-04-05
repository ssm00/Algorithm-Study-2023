package week5.Seo_Sumin;

import java.util.ArrayList;

/**
 * 프로그래머스 소수찾기
 * 순열만들기 + 소수찾기
 */

public class Ex03 {

    static ArrayList<Integer> list = new ArrayList<>();
    static int ch[];

    public int solution(String numbers) {
        int ans = 0;
        String arr[] = new String[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = String.valueOf(numbers.charAt(i));
        }
        ch = new int[arr.length];
        
        //순열은 길이별로 생성
        //모든 길이의 순열이 필요하다면 for문으로
        for (int i = 1; i < numbers.length()+1; i++) {
            permutation(arr,i,"",0);
        }
        
        //숫자 소수인지 확인
        for (int i = 0; i<list.size(); i++) {
            Integer a = list.get(i);
            if (prim(a)) {
                ans++;
            }
        }
        return ans;
    }

    //순열
    //arr, 끝나는 레벨, temp 스트링(때에 따라 배열), 현재 위치
    public void permutation(String [] arr,int depth, String temp, int L) {
        if (depth == L) {
            int i = Integer.parseInt(temp);
            if (!list.contains(i)) {
                list.add(i);
            }
            return;
        }else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    temp += arr[i];
                    permutation(arr, depth, temp, L + 1);
                    ch[i] = 0;
                    //돌아오면 하나만 빼기
                    temp = temp.substring(0,temp.length()-1);
                }
            }
        }
    }
    
    //소수 판별
    public boolean prim(int n) {
        if(n<2) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String num1 = "1231";
        String num2 = "23";
        Ex03 ex03 = new Ex03();
        System.out.println("ex03 = " + ex03.solution(num1));
    }
}
