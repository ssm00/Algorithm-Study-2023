package week1.YooByeong_gue;

import java.util.*;

public class Main4 {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
    // 효율성 테스트 3,4 시간초과
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i], i);
        }
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
        }
        return answer;
    }
    // 효율성 테스트 3,4 시간초과
//    public static boolean solution(String[] phone_book) {
//        boolean answer = true;
//        Arrays.sort(phone_book, Comparator.comparing(String::length));
//        for(int i=0; i<phone_book.length-1;i++){
//            for(int j=i+1; j<phone_book.length;j++){
//                String temp = phone_book[j].substring(0, phone_book[i].length());
//                if(temp.equals(phone_book[i])){
//                    answer = false;
//                    return answer;
//                }
//            }
//        }
//        return answer;
//    }
}
