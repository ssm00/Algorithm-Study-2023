package week3.Seo_Sumin;

import java.util.*;

/**
 * 프로그래머스 디스크 컨트롤러
 * 시작시간 짧은거 -> 수행시간 짧은거 순으로 실행
 * pq 사용시 ()안에 comparator구현가능
 * pq 사용시 comparator2개 구현하고 싶으면 ()안에 comparator 작성
 */

public class Ex02 {

    class Disk {
        int start;
        int time;

        public Disk(int start, int time) {
            this.start = start;
            this.time = time;
        }

        public int timeMinusStart() {
            return this.time - this.start;
        }
    }


    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Disk> disks = new PriorityQueue<>(Comparator.comparing(d -> d.start));
        PriorityQueue<Disk> canWork = new PriorityQueue<>(Comparator.comparing(d -> d.time));


        for (int i = 0; i < jobs.length; i++) {
            disks.add(new Disk(jobs[i][0], jobs[i][1]));
        }

        int size = disks.size();
        int accumulate = disks.peek().start;

        while(!disks.isEmpty() || !canWork.isEmpty()) {
            //실행가능한거 옮기기
            while (true) {
                if (!disks.isEmpty() && disks.peek().start <= accumulate) {
                    canWork.add(disks.poll());
                } else {
                    break;
                }
            }
            //canWork가 있을때 한개를 수행하고 시행될수 있는 작업이 생길수 있으니까 한개씩 해야함 한번에 다하면 안됨
            if (!canWork.isEmpty()) {
                Disk poll = canWork.poll();
                int calculate = poll.time + accumulate - poll.start;
                accumulate += poll.time;
                answer += calculate;
            }
            //canWork가 비였는데 disk는 있을때 -> 제일 먼저 시작되는거 실행
            else {
                Disk poll = disks.poll();
                int calculate = poll.start - accumulate + poll.time;
                accumulate += calculate;
                answer += poll.time;
            }

        }
        return answer/size;
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        int [][] arr = {
                {7, 8},
                {3, 5},
                {9, 6}
                };

        int [][] arr1 = {
            {0, 3},
            {1, 9},
            {2, 6}
        };

        System.out.println(ex02.solution(arr));
        System.out.println(ex02.solution(arr1));
    }
}
