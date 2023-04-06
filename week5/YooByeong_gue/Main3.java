package week5.YooByeong_gue;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args){
        solution("1234");
    }
    static List<Integer> list = new ArrayList<>();
    public static int solution(String numbers) {
        int answer = 0;
        String ex = "1234";
        dfs(ex, "", 0);

        return answer;
    }

    private static void dfs(String ex, String temp, int index) {
        if(temp.length() > ex.length()) return;
        if(temp != "" && !(list.contains(Integer.parseInt(temp)))) {
            list.add(Integer.parseInt(temp));
            System.out.println("temp = " + temp);
        }
        for(int i=0;i<ex.length();i++){
            temp = temp + ex.charAt(i);
            dfs(ex, temp, index);
        }

    }
}
