package week3.YooByeong_gue;

import java.util.PriorityQueue;

public class Main1 {

    // 섞은 음식의 스코빌 지수 =
    // 가장 맵지 않은 음식의 스코빌 지수 +
    // (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: scoville) minHeap.offer(i);
        int min, nextMin, mixed;
        while(true){
            if(minHeap.peek() >= K) break;
            min = minHeap.poll();
            nextMin = minHeap.poll();
            mixed = min + (nextMin*2);
            minHeap.offer(mixed);
            answer++;
            if(minHeap.size() == 1 && minHeap.peek() < K) return -1;
        }
        return answer;
    }
}
