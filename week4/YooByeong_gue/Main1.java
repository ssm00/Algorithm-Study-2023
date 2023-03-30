package week4.YooByeong_gue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i< commands.length; i++){
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                temp.add(array[j]);
            }
            Collections.sort(temp);
            result.add(temp.get(commands[i][2]-1));
            temp.clear();
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
