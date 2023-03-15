package week2.YooByeong_gue;

public class Main3 {

    boolean solution(String s) {
        int left=0, right =0;
        for(int i=0; i<s.length();i++){
            if(left < right) return false;
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')') right++;
        }
        if(left != right) return false;
        return true;
    }
}
