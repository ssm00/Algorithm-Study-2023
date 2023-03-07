package week1Hash;
import java.util.HashSet;
import java.util.List;

/**
 * 프로그래머스 전화목록
 * 포함을 확인할때 이중 for문 이라면 hashmap사용을 고려 
 * hashmap의 containskey는 O(1) Hashset contains도 마찬가지
 * @author sumin
 *
 */

public class Ex03 {
	
	public boolean solution(String[] phone_book) {

		HashSet<String> set = new HashSet<String>();
		
		for(String number : phone_book) {
			set.add(number);			
		}
		
		for(String number : phone_book) {
				for(int i=0; i<number.length(); i++) {
					if(set.contains(number.substring(0,i)))
						return false;
				}
		}
		return true;
    }
	
	
	public static void main(String[] args) {
		String [] arr1 = {"123","456","789"};
		Ex03 e = new Ex03();
		System.out.println(e.solution(arr1));
		
	}
}
