package week2.Seo_Sumin;

import java.util.*;

/**
 * 프로그래머스 프린터
 * queue에서 최고값 확인 하려면 그냥 O(N)
 * for문으로 queue돌리고 비교
 */
public class Ex04 {


    class Paper{
        int location;
        int priority;

        public Paper(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Paper(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            //하나빼서 우선순위가 가장큰지 확인
            Paper poll = q.poll();
            boolean pIsbig = true;
            for (Paper p : q) {
                if (p.priority > poll.priority) {
                    pIsbig = false;
                }
            }

            //우선순위가 가장크다면
            if (pIsbig) {   //지금빼낸게 우선순위가 가장큼
                if (poll.location == location) {    //정답이면 빼내고 끝
                    answer++;
                    return answer;
                } else {        //정답아니면 빼내기만
                    answer++;
                }
            } else {            //우선순위 낮은거면 뒤에 다시넣음
                q.offer(poll);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr1 = {1, 1, 9, 1, 1, 1};
        int l = 0;
        Ex04 t = new Ex04();
        System.out.println(t.solution(arr1,l));
    }
}
