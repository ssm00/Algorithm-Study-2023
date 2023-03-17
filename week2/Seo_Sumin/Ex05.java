package week2.Seo_Sumin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 프로그래머스 다리를 지나가는 트럭
 * 다리 길이만큼 초가 걸린다는 말이 빠져있음
 */

public class Ex05 {

    class Truck{
        int position;
        int weight;

        public Truck(int position, int weight) {
            this.position = position;
            this.weight = weight;
        }

        public void move() {
            this.position = this.position - 1;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int end = 0;
        Queue<Truck> start = new LinkedList<>();
        Queue<Truck> middle = new LinkedList<>();

        //1. 트럭을 시작 큐에 추가
        for (int i = 0; i < truck_weights.length; i++) {
            start.offer(new Truck(bridge_length, truck_weights[i]));
        }

        //2. 트럭 옮기기
        while (end != truck_weights.length) {
            Truck sPeek = start.peek();
            


            if (sPeek == null) {//start 큐는 다 빠지고 middle 큐는 차있을때
                //중간 트럭 움직이기
                while (end != truck_weights.length) {
                    end = moveMiddleTruck(end, middle);
                    time++;
                }
                return time;
            }

            end = moveMiddleTruck(end, middle);
            //다리위의 트럭 무게 구하기
            int middleSum = 0;
            for (Truck t : middle) {
                middleSum += t.weight;
            }
            if (middleSum + sPeek.weight > weight) {
                time++;
            } else if (middleSum + sPeek.weight < weight) {
                middle.offer(start.poll());
                time++;
            } else if (middle.size() == bridge_length) {
                time++;
            }
        }
        return time;
    }

    private static int moveMiddleTruck(int end, Queue<Truck> middle) {
        Queue<Truck> temp = new LinkedList<>(middle);
        for (Truck t : temp) {
            if (t.position == 1) {  //첫번째면 빼기
                middle.poll();
                end++;
            } else {            //아니면 움직이기
                t.move();
            }
        }
        return end;
    }

    public int solution1(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        int sum = 0; // 다리를 건너는 트럭들의 무게 합

        for(int t : truck_weights) {

            while(true) {
                //큐가 비어있다면 다음 트럭 삽입
                if(q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }
                //큐의 사이즈와 다리의 길이가 같다면 큐에서 큐에서 처음 값을 빼고 최대 무게 -
                else if(q.size() == bridge_length) {
                    sum -= q.poll();
                }
                //큐가 비어있지 않을 때
                else {
                    //다음 트럭이 최대 무게 초과
                    if(sum + t > weight) {
                        q.offer(0);
                        answer++;
                    }
                    //다음 트럭이 최대 무게 이내
                    else {
                        q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }

        //걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return answer + bridge_length;
    }


    public static void main(String[] args) {
        Ex05 t = new Ex05();
        //System.out.println("t = " + t.solution(2,10,new int [] {7,4,5,6}));
        //System.out.println("t = " + t.solution(100,100,new int [] {10}));
        System.out.println("t = " + t.solution(100,100,new int [] {10,10,10,10,10,10,10,10,10,10}));
    }
}
