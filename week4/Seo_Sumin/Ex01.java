package week4.Seo_Sumin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 프로그래머스 k번째수
 * list.sublist시 끝값은 제외
 */
public class Ex01 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
            List<Integer> temp = clone.subList(commands[i][0] - 1, commands[i][1] );
            temp.sort(Integer::compareTo);
            answer[i] = temp.get(commands[i][2]-1);
        }
        return answer;
    }


    public static void main(String[] args) {
        int [] arr1 = {1, 5, 2, 6, 3, 7, 4};
        int [][] arr2 = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}};

        Ex01 ex01 = new Ex01();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(ex01.solution(arr1,arr2)[i]);
        }
    }
}
