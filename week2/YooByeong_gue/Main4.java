package week2.YooByeong_gue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main4 {
    static ArrayList<Integer> prioritieList = new ArrayList<>();

    public static void main(String[] args){
        int[] a = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(a, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<priorities.length;i++){
            queue.offer(i);
        }
        for(int i=0; i<priorities.length;i++){
            prioritieList.add(priorities[i]);
        }
        int fileNumber;
        while(!(queue.isEmpty())){
            fileNumber = queue.poll();
            if(fileNumber == maxPro()) {
                list.add(fileNumber);
                list.remove(fileNumber);
            }
            else queue.offer(fileNumber);
        }
        answer = list.indexOf(location);
        return answer;
    }

    private static int maxPro() {
        int fileNumber=0;
        int max=prioritieList.get(0);
        for(int i=1; i<prioritieList.size();i++){
            if(max < prioritieList.get(i)){
                max = prioritieList.get(i);
                fileNumber = i;
            }
        }
        return fileNumber;
    }
}
