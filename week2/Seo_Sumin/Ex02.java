package week2.Seo_Sumin;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 프로그래머스 기능개발
 * ceil 올림
 * round 반올림
 * floor 내림
 * 같은숫자 붙어있는것 확인시 stack 구조사용
 */
public class Ex02 {

    public int[] solution(int[] progresses, int[] speeds) {
        
        //1. 처리 일수 계산
        ArrayList<Integer> day = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int ceil = ceil(progresses[i], speeds[i]);
            day.add(ceil);
        }

        //2. 날짜가 작거나 같으면 큐에넣기
        Deque<Integer> deque = new LinkedList<>();
        deque.push(day.get(0));
        for (int i = 1; i < day.size(); i++) {
            Integer top = deque.peekLast();
            Integer nextNum = day.get(i);
            if (top >= nextNum) {
                deque.addLast(top);
            }else{
                deque.addLast(nextNum);
            }
        }
        
        //3. 덱 같은숫자만큼 겹치는 갯수 -> 출력값

        ArrayList<Integer> ans = new ArrayList<Integer>();
        int temp = deque.pollFirst();
        int cnt=1;
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            int nextNum = deque.pollFirst();
            if (temp == nextNum) {
                cnt++;
            }else{
                ans.add(cnt);
                temp = nextNum;
                cnt = 1;
            }
        }
        ans.add(cnt);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    
    //걸리는 일수 계산
    public int ceil(int progress, int speed){
        return (int) Math.ceil((double) (100 - progress) / (double) speed);
    }


    public static void main(String[] args) {
        Ex02 t = new Ex02();
        int[] arr1 = {95, 90, 99, 99, 80, 99};
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        int[] solution = t.solution(arr1, arr2);
        for (int s : solution) {
            System.out.println(s);
        }
    }
}
