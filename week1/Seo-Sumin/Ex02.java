package week1Hash;

import java.util.HashMap;

public class Ex02 {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		for(String part : participant) {
			list.put(part, list.getOrDefault(part, 0) + 1);
		}
		for(String comp : completion) {
			list.replace(comp, list.get(comp) -1);
		}
		String ans = "";
		for(String s : list.keySet()) {
			if(list.get(s) == 1) {
				ans = s;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		Ex02 ex = new Ex02();
		String [] arr1 = {"mislav", "stanko", "mislav", "ana"};
		String [] arr2 = {"stanko", "ana", "mislav"};
		System.out.println(ex.solution(arr1, arr2));
	}
}
