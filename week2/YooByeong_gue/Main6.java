package week2.YooByeong_gue;

import java.util.ArrayList;
import java.util.Stack;

public class Main6 {

    public int[] solution(int[] prices) {
        int[] answer = {};
        int index=0;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i : prices) result.add(0);

        while(index < prices.length){
            stack.add(prices[index]);

        }


        return answer;
    }
}
