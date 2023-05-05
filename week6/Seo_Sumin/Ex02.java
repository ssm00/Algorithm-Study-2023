package week6.Seo_Sumin;

/**
 * 프로그래머스 조이스틱
 * 위치를 움직인횟수와 알파벳조작횟수를 따로 계산해서 더해야함.
 * 너무복잡
 *
 */
public class Ex02 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += Math.min(Math.abs(name.charAt(i)-'A'), Math.abs('Z'-name.charAt(i)+1));
            }
            int next = i+1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + i + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        answer += move;
        return answer;
    }

    public static void main(String[] args) {
        String input1 = "BBBBAAAAAAAB";
        Ex02 ex02 = new Ex02();
        System.out.println("input1 = " + ex02.solution(input1));

    }
}
