package week1.YooByeong_gue;

import java.util.HashMap;

public class Main5 {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length;i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        int answer = 1;
        for(Integer value : map.values())
            answer *= value+1;
        return answer-1;
    }
}
