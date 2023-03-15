package week2.YooByeong_gue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main2 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int days = 0;
        for(int i=0; i<progresses.length;i++){
            days = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] >0) days++;
            queue.add(days);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 5 10 1 1 20 1
        days =queue.poll();
        int count =1;
        int next = 0;
        while(!(queue.isEmpty())){
            next = queue.poll();
            if(days < next){
                arrayList.add(count);
                days = next;
                count =0;
            }
            count++;
        }
        arrayList.add(count);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

}
