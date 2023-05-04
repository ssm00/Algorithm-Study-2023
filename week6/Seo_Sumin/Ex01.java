package week6.Seo_Sumin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 체육복
 * 그리디
 * 배열 내림차순 정리하는것 까먹지 말기
 */
public class Ex01 {

    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lost1 = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserve1 = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        Collections.sort(lost1);
        Collections.sort(reserve1);

        List<Integer> intersection = new ArrayList<>(lost1);
        intersection.retainAll(reserve1);
        lost1.removeAll(intersection);
        reserve1.removeAll(intersection);
        for (Integer i : reserve1) {
            for (Integer j : lost1) {
                if (i - 1 == j || i + 1 == j) {
                    lost1.remove(j);
                    break;
                }
            }
        }
        return n-lost1.size();
    }
    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        int n = 5;
        int arr1 [] = {3,4};
        int arr2 [] = {1,3,5};
        System.out.println(ex01.solution(n,arr1,arr2));
    }
}
