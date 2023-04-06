package week5.YooByeong_gue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main7 {
    public int solution(String word) {
        String alphabet = "AEIOU";
        int[] rate = {781, 156, 31, 6, 1};
        int answer = word.length();
        for(int i=0;i<word.length();i++){
            answer += rate[i]*alphabet.indexOf(word.charAt(i));
        }
        return answer;
    }
}
