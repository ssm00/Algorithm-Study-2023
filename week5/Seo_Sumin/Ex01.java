package week5.Seo_Sumin;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프로그래머스 최소직사각형
 * 모든 카드의 긴쪽 값을 가로 작은값은 세로로 넣으면
 * 가로값은 가로중 가장긴값
 * 세로값은 가로세로바꿔봐야
 * 세로값이 무조건 길어지니까 안바꾸고 세로중 가장긴값 선택
 */
public class Ex01 {


    public int solution(int[][] sizes) {
        PriorityQueue<Integer> verticalQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> horizontalQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < sizes.length; i++) {
            int v = sizes[i][0];
            int h = sizes[i][1];
            //항상 가로를 더 긴쪽으로 넣기
            if (v > h) {
                verticalQ.add(v);
                horizontalQ.add(h);
            } else {
                verticalQ.add(h);
                horizontalQ.add(v);
            }
        }
        return verticalQ.peek() * horizontalQ.peek();
    }
    public static void main(String[] args) {
        int[][] arr1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        Ex01 ex01 = new Ex01();
        int solution = ex01.solution(arr1);
        System.out.println("solution = " + solution);
    }
}
