package week6.Seo_Sumin;

import java.util.Arrays;
import java.util.Collections;

/**
 * 프로그래머스 그리디 구명보트
 * 제일큰거, 제일작은거 더하기 비교
 */
public class Ex04 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] people1 = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(people1,Collections.reverseOrder());
        int i = 0;
        int j = people1.length-1;
        while (i < j) {
            if (people1[i] + people1[j] <= limit) {
                people1[i] = people1[i] + people1[j];
                j--;
            }else {
                i++;
                answer++;
            }
        }
        if (i == j) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr1 = {70, 50, 80, 50};
        int limit = 100;
        Ex04 ex04 = new Ex04();
        System.out.println("ex04.solution(arr1,limit) = " + ex04.solution(arr1,limit));
    }
}
