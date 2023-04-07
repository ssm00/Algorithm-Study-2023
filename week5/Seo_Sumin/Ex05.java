package week5.Seo_Sumin;


import java.util.ArrayList;

/**
 * 프로그래머스 피로도
 * dfs로 모두 찾기
 * Math.max 하고 ans로 넣어주는거 까먹지 말기..
 */

public class Ex05 {

    class Node{
        public int required;
        public int minus;

        public Node(int required, int minus) {
            this.required = required;
            this.minus = minus;
        }
    }

    public int solution(int k, int[][] dungeons) {
        int depth = dungeons.length;
        ch = new int[depth];
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < dungeons.length; i++) {
            nodeList.add(new Node(dungeons[i][0], dungeons[i][1]));
        }
        dfs(nodeList, depth, 0, k);

        return ans;
    }

    static int ans = 0;
    static int ch[];
    public void dfs(ArrayList<Node> node , int depth, int level, int now) {
        if (depth == level) {
            ans = depth;
            return;
        } else {
            for (int i = 0; i < node.size(); i++) {
                if (ch[i] == 0 && now >= node.get(i).required) {
                    ch[i] = 1;
                    ans = Math.max(ans, level+1);
                    dfs(node,depth,level+1,now-(node.get(i).minus));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int k = 80;
        int[][] arr = {{80, 20},
                {50, 40},
                {30, 10}};

        Ex05 ex05 = new Ex05();
        System.out.println(ex05.solution(80, arr));
    }
}
