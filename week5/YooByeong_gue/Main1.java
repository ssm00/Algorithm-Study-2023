package week5.YooByeong_gue;

public class Main1 {
    int[][] cards;
    int first;
    int second;
    public int solution(int[][] sizes) {
        int first;
        int second;
        int width=0, length=0;
        int answer = 0;
        for(int i=0; i< sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]) {
                first = sizes[i][0];
                second = sizes[i][1];
            }
            else {
                second = sizes[i][0];
                first = sizes[i][1];
            }
            if(width <= first) width = first;
            if(length <= second) length = second;
        }
        answer = width*length;
        return answer;
    }

    //stackOverFlow
    private int findResult(int width, int length, int[][] cards, int i) {
        if(i >= cards.length) return width*length;

        if(cards[i][0] >= cards[i][1]) {
            first = cards[i][0];
            second = cards[i][1];
        }
        else {
            second = cards[i][0];
            first = cards[i][1];
        }
        if(width <= first) width = first;
        if(length <= second) length = second;

        return findResult(width, length, cards,i++);
    }


}
