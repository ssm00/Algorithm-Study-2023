package week2.Seo_Sumin;

import java.util.*;

/**
 *
 */
public class Ex01 {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if (!deque.peekLast().equals(arr[i])) {
                deque.add(arr[i]);
            }
        }
        int[] answer = new int[deque.size()];
        int i = 0;
        while(!deque.isEmpty()){
            answer[i] = deque.pollFirst();
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex01 t = new Ex01();
        int [] arr1 = {1,1,3,3,0,1,1};
        int [] ans = t.solution(arr1);
        for(int i : ans){
            System.out.println(i);
        }
    }
}
