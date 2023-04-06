package week5.Seo_Sumin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 전력망을 둘로 나누기
 *
 */

public class Ex06 {
    static ArrayList<ArrayList<Integer>> graph;
    static int ch[];
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        for (int i = 0; i < wires.length; i++) {
            int n1 = bfs(wires[i][0],wires[i][1],n+1);
            int n2 = bfs(wires[i][1],wires[i][0],n+1);
            answer = Math.min(Math.abs(n1-n2), answer);
        }

        return answer;
    }

    public int bfs(int a, int b, int n) {
        Queue<Integer> q = new LinkedList<>();
        ch = new int[n];
        ch[a] = 1;
        q.offer(a);
        int level=1;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i : graph.get(poll)) {
                if (ch[i] == 0 && i != b) {
                    ch[i]=1;
                    q.offer(i);
                }
            }
            level++;
        }
        return level;
    }


    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        int n1 = 9;
        int [][] arr1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println("ex06 = " + ex06.solution(n1, arr1));
    }
}
