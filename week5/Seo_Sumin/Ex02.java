package week5.Seo_Sumin;

import java.util.ArrayList;

/**
 * 프로그래머스 모의고사
 * 학생정답을 배열로 만들어 비교
 *
 */

public class Ex02 {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int alen = 5;
        int blen = 8;
        int clen = 10;

        int aans = 0;
        int bans = 0;
        int cans = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % alen]) {
                aans++;
            }
            if (answers[i] == b[i % alen]) {
                bans++;
            }
            if (answers[i] == c[i % alen]) {
                cans++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Math.max(aans, Math.max(bans, cans));
        if (max == aans) {
            ans.add(1);
        }if (max == bans) {
            ans.add(2);
        }if (max == cans) {
            ans.add(3);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,4,2};
        int arr2[] = {1,2,3,4,5};
        Ex02 ex02 = new Ex02();
        int[] solution = ex02.solution(arr);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
