package week1Hash;

import java.util.HashMap;

/**
 * 프로그래머스 위장
 * 경우의수 계산
 * 2개인경우 0(안입기),1,2   3가지 경우의수 모두안입기 1개 빼야함
 * @author sumin
 *
 */

public class Ex04 {
	public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int ans = 1;
        if(map.values().size()==1) {
        	return map.get(clothes[0][1]);
        }
        //int k = map.values().stream().reduce((a,b) -> (a+1)*(b+1)).get();
        for(int n : map.values()) {
        	ans *= (n+1);
        }
        return ans-1;
	}
	
	public int combination(int n, int r) {
		if(r == 0 || n == r) {// nCr에서 nC0 == 1, nCn == 1 
			return 1;
		}else { // nCr = n-1Cr-1 + n-1Cr
			return combination(n-1, r-1) + combination(n-1, r);
		}
	}
	
	public static void main(String[] args) {
		String [][] arr1 = {{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}}; 
		
		Ex04 e = new Ex04();
		System.out.println(e.solution(arr1));
	}
}
