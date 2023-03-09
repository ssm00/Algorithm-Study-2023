package week1.YooByeong_gue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main6 {
    public static void main(String[] args){
        String[] a = {"classic", "pop", "classic", "classic", "pop"};
        int[] b = {500, 600, 150, 800, 2500};
        System.out.println(solution(a,b));
    }
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>(); // <장르, 총 재생 수>
        for(int i=0; i<genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }

        List<String> gOrder = new ArrayList<>(map.keySet()); // 총 재생 수가 많은 장르 순으로 정렬
        Collections.sort(gOrder, ((o1, o2) -> Integer.compare(map.get(o2),map.get(o1))));

        HashMap<String, List<Integer>> map2 = new HashMap<>(); // <장르, 해당 노래 고유번호들>
        List<Integer> temp;
        for(int i=0;i< genres.length;i++){
            temp = map2.getOrDefault(genres[i],new ArrayList<>());
            temp.add(i);
            map2.put(genres[i],temp);
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> song;
        for(String genre : gOrder){ // 총 재생 수가 많은 장르 순서대로 해당 장르의 노래들의 재생 수가 가장 높은 2개 넣기
            song = map2.get(genre);
            if(song.size()==1) // 해당 장르의 노래가 하나일 경우
                result.add(song.get(0));
            else { // 해당 장르의 노래가 둘 이상일 경우
                Collections.sort(song, ((o1, o2) -> Integer.compare(plays[o2], plays[o1]))); // 고유번호를 재생 순으로 정렬
                result.add(song.get(0));
                result.add(song.get(1));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
