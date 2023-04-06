package week5.YooByeong_gue;

import java.util.LinkedList;
import java.util.List;

public class Main6 {
    public class Node{
        private List<Node> liked;
        public Node(){
        }
        public void addLink() {

        }
    }

    public int solution(int n, int[][] wires) {
        int answer = -1;
        LinkedList<Node> tops = new LinkedList<>();
        tops.add(null);
        for(int i=1;i<=n;i++) {
            tops.add(new Node());
        }
        return answer;
    }
}
