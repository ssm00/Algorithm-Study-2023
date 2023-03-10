package week1Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 프로그래머스 베스트앨범
 * String 비교시 equals 사용
 * HashMap sort시 복잡함인지
 * 비교 시 Comparable인터페이스 compareTo 구현
 * compareTo 기준 그냥 빼기하면 오름차순 
 * 내림차순 파라미터 객체값 - 지금객체값
 * @author sumin
 *
 */
//장르별로 2개씩 뽑음 그다음 sort 
public class Ex05 {
	
	class Song implements Comparable<Song>{
		String genre;
		int id;
		int playtime;
		
		public Song(String genre,int id, int playtime) {
			this.genre = genre;
			this.id = id;
			this.playtime = playtime;
		}
		
		@Override
		public int compareTo(Song o) {
			if(this.playtime == o.playtime) {
				return  this.id - o.id;
			}else {
				return o.playtime - this.playtime;
			}
		}
	}
	
	public int[] solution(String[] genres, int[] plays) {
        //장르  - <곡번호 - 재생횟수>
		
		//곡최대값 비교하기위한 hashmap
		HashMap<String, Integer> mainList = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			mainList.put(genres[i], mainList.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		//hashmap 최대값구하기
		ArrayList<String> sortedGenre = new ArrayList<String>();
		
		while(mainList.size()!=0) {
			int max = -1;
			String addGenre = "";
			for(String g : mainList.keySet()) {
				if(mainList.get(g) > max) {
					max = mainList.get(g);
					addGenre = g;
				}
			}
			sortedGenre.add(addGenre);
			mainList.remove(addGenre);
		}
		
		//전체 노래 리스트 만들기
		ArrayList<Song> songlist = new ArrayList<>();
		for(int i=0; i<plays.length; i++) {
			songlist.add(new Song(genres[i],i,plays[i]));
		}
		
		//1번방법
		Collections.sort(songlist);
		//전체 노래리스트돌면서 장르가 같으면 temp에 저장, 내림차순 sort한뒤 정답으로 옮기기
		ArrayList<Song> ansList = new ArrayList<>();
		for(String g : sortedGenre) {
			ArrayList<Song> temp = new ArrayList<>();
			for(Song s :songlist) {
				if(s.genre.equals(g)) {
					temp.add(s);
				}
			}
			//2번방법
			Collections.sort(temp, (o1, o2) -> o2.playtime - o1.playtime);
			//조건 1개아님 2개
			ansList.add(temp.get(0));
			if(temp.size()!=1) {
				ansList.add(temp.get(1));
			}
		}
		
		//출력
		int [] ans = new int[ansList.size()];
		for(int i=0; i<ansList.size(); i++) {
			ans[i] = ansList.get(i).id;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Ex05 t = new Ex05();
		String [] gen = {"classic", "pop", "classic", "classic", "pop"};
		int [] plays = {500, 600, 150, 800, 2500};
		
		String [] gen2 = {"a", "b", "c", "d", "a", "d", "d", "d", "a", "a", "c", "c"};
		int [] plays2 = {100, 300, 400, 150, 100, 300, 200, 600, 700, 110, 900, 9000};
		
		int arr [] =t.solution(gen, plays);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
	}
}
