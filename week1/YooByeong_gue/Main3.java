package week1.YooByeong_gue;

import java.util.HashMap;
public class Main3 {
    public static void main(String[] args){
        String[] a = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b = {"josipa", "marina", "vinko", "nikola"};
        System.out.println(solution(a,b));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i<completion.length;i++)
            map.put(i,completion[i]);
        for(String name : participant){
            if(!map(name)){
                answer = name;
                break;
            }
               map.values().remove(name);
        }
        System.out.println(map.values().toString());
        return answer;
    }
}
