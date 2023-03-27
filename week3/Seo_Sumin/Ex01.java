package week3.Seo_Sumin;

import java.util.PriorityQueue;

/**
 * 효율적인 최대값, 최솟값 찾기
 * heap이용 -> priorityQueue 사용
 */

public class Ex01 {

    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int sc : scoville){
            heap.add(sc);
        }

        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }
            Integer first = heap.poll();
            Integer second = heap.poll();
            int calculate = first + (second * 2);
            heap.add(calculate);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        int [] arr1 = {1, 2, 3, 9, 10, 12};
        int k1= 7;
        System.out.println("ex01.solution(arr1,k1) = " + ex01.solution(arr1,k1));
    }

}
