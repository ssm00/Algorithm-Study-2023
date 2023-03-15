package week2.YooByeong_gue;

import java.util.ArrayList;
import java.util.Stack;

public class Main1 {

    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for(int i=1; i<arr.length;i++){
            if(temp.get(temp.size()-1) != arr[i]){
                temp.add(arr[i]);
            }
        }
        answer = temp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
