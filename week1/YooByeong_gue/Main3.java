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
        // 1. 참가자 명단에서 각 동명이인이 몇명인지 체크한다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        // 2. 완주자 명단에 이름이 있다면 해당 이름의 명 수를 감소한다.
        for(String key : completion){
            map.put(key, map.get(key) -1);
        }
        // 3. 참가자 명단에서 아직 동명이인의 명 수가 0이 아닌 사람을 찾는다. = answer
        for(String key : map.keySet()){
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
/*  정확성 테스트 통과 / 효율성 테스트 실패 (시간초과)
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i<completion.length;i++)
            map.put(i,completion[i]);
        for(String name : participant){
            if(!map.containsValue(name)){
                answer = name;
                break;
            }
            map.values().remove(name);
        }
        return answer;
    }

 */