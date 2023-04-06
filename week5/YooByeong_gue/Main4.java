package week5.YooByeong_gue;

public class Main4 {
    public static void main(String[] args){
        solution(10,2);
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width=0, length=0;
        int temp = brown + yellow;

        for(int i=3;i < brown/2; i++){
            if(temp%i == 0) {
                width = temp/i;
                length = i;
                if((width-2)*(length-2) == yellow) break;
            }
        }
        answer[0] = width;
        answer[1] = length;
        return answer;
    }
}
