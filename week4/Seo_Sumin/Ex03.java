package week4.Seo_Sumin;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 프로그래머스 H-index
 * 단순규칙만 찾으면됨
 */
public class Ex03 {
    public int solution(int[] citations) {
        int answer = 0;
        Integer [] ints = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(ints, Collections.reverseOrder());
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= i + 1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr1 = {3, 0, 6, 1, 5};
        int [] arr2 = {0,1,1,1,3,5,6};


        Ex03 ex03 = new Ex03();
        System.out.println(ex03.solution(arr2));
    }
}
