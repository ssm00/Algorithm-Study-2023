package week1Hash;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 프로그래머스 포켓몬
 * 중복제거가되는 hashset사용
 * hashset의 특징인 배열의 중복제거는 stream으로 구현가능 
 * 배열의 중복제거는 stream의 사용을 고려하자 
 * @author sumin
 *
 */
public class Ex01 {
	public int solution(int[] nums) {

		
		int answer = 0;
		int maxLength = (nums.length)/2;
		HashSet<Integer> basket = new HashSet<>();
		for(int poketmonId : nums) {
			basket.add(poketmonId);
		}
		if(basket.size() > maxLength) {
			answer = maxLength;
		}else {
			answer = basket.size();
		}
        return answer;
        /**
		 * stream 사용 
		 */
//       int num = (int) Arrays.stream(nums).distinct().count();
//		if (nums.length / 2 < n)
//			return nums.length / 2;
//		return num;
		
    }
	
	public static void main(String[] args) {
		Ex01 e = new Ex01();
		int [] arr1 = {3,1,2,3};
		int [] arr2 = {3,3,3,2,2,4};
		int [] arr3 = {3,3,3,2,2,2};
		System.out.println(e.solution(arr1));
		System.out.println(e.solution(arr2));
		System.out.println(e.solution(arr3));
	}
}
