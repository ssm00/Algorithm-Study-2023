package week3.Seo_Sumin;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프로그래머스 이중우선위큐
 * priority queue remove 원하는 요소 가능함
 * 최대, 최소 찾는경우 2개 만들어서 서로 요소 지우면서 사용가능
 */

public class Ex03 {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[2];
        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("I")) {
                minPq.offer(Integer.parseInt(split[1]));
                maxPq.offer(Integer.parseInt(split[1]));
            } else if (split[0].equals("D")) {
                if (split[1].equals("-1")) {
                    Integer min = minPq.poll();
                    maxPq.remove(min);
                }else {
                    Integer max = maxPq.poll();
                    minPq.remove(max);
                }
            }
        }
        if (minPq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String arr1 [] = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        Ex03 ex03 = new Ex03();
        int[] solution = ex03.solution(arr1);

        for (int x : solution) {
            System.out.println(x);
        }

    }
}
