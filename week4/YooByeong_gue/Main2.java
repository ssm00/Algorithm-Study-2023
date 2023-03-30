package week4.YooByeong_gue;

import java.util.Arrays;
import java.util.Comparator;

public class Main2 {

    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];

        for(int i = 0 ; i<str.length;i++) str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for(String arr : str) answer+=arr;
        if(str[0].equals("0")) answer = "0";
        return answer;
    }
}
