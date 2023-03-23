package week3.YooByeong_gue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main2 {

    public static int solution(int[][] jobs) {
        int answer = 0;
        int jobsIdx =0;
        int end=0;
        int complete=0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Task> heap = new PriorityQueue<>();
        while(complete < jobs.length){
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                heap.offer(new Task(jobs[jobsIdx][0], jobs[jobsIdx][1]));
                jobsIdx++;
            }

            if(heap.isEmpty()) end = jobs[jobsIdx][0];
            else{
                Task temp = heap.poll();
                answer += temp.getSpendTime() + end - temp.getRequestTime();
                end += temp.getSpendTime();
                complete++;
            }
        }
        return answer/jobs.length;
    }

    static class Task implements Comparable<Task>{
        private int requestTime;
        private int spendTime;
        public Task(int requestTime, int spendTime){
            this.requestTime = requestTime;
            this.spendTime = spendTime;
        }
        public int getRequestTime() {
            return requestTime;
        }
        public int getSpendTime() {
            return spendTime;
        }

        @Override
        public int compareTo(Task target) {
            if(this.getSpendTime() < target.getSpendTime()) return -1;
            else if (this.getSpendTime() > target.getSpendTime()) return 1;
            return 0;
        }
    }

    public static void main(String[] args){
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));

    }
}
