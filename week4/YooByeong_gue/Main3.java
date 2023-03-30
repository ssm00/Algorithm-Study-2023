package week4.YooByeong_gue;

import java.util.Arrays;
import java.util.Collections;

public class Main3 {
    public static int solution(int[] citations) {
        int answer = 0;
        Integer[] temp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());
        for(int i=0;i< temp.length;i++){
            if(temp[i] < i+1) return i;
            if(temp[i] == i+1) return i+1;
        }
        return temp.length;
    }

    public static void main(String[] args){
        int[] test = {10, 50, 100};
        solution(test);
        System.out.println(solution(test));
    }
}
