package week2.YooByeong_gue;

import java.util.LinkedList;
import java.util.Queue;

public class Main5 {

    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println("result = "+solution(bridge_length,weight,truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridge_current_weight=0;
        int time=0;
        int index=0;
        Queue<Integer> running_truck_queue = new LinkedList<>();

        while(index < truck_weights.length){
            if(bridge_current_weight + truck_weights[index] <= weight) {
                running_truck_queue.offer(truck_weights[index]);
                bridge_current_weight += truck_weights[index];
                index++;
                time++;
            }
            else if (running_truck_queue.size() < bridge_length) {
                running_truck_queue.offer(0);
                time++;
            }
            else{
                bridge_current_weight -= running_truck_queue.poll();
            }
        }

        return time+bridge_length;
    }
}
