package week2.Seo_Sumin;

/**
 * 프로그래머스 주식가격
 */
public class Ex06 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < answer.length; i++) {
            for(int j = i + 1; j < answer.length; j++) {
                answer[i]++;

                if(prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
