package week5.Seo_Sumin;

/**
 * 프로그래머스 카펫
 *
//        x * y = m+n;
//        x-2 * y-2 = n;
//        xy = 12;
//        xy -2x -2y +4 = n;
//        -2(x+y) = +n-4-(m+n);
 */
public class Ex04 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = (4+brown) / 2;
        int x = 3;
        int y = 3;
        for (int i = x; i <= sum; i++) {
            for (int j = y; j <= sum; j++) {
                if (i + j == sum && i*j == brown+yellow) {
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 24;
        int m = 24;
        Ex04 ex04 = new Ex04();
        int[] solution = ex04.solution(n, m);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
