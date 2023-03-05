package week1.YooByeong_gue;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // case1
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        String result = plus(first,second);
        System.out.println(result);

        // case2
        BigInteger bigInteger1 = new BigInteger(first);
        BigInteger bigInteger2 = new BigInteger(second);
        System.out.println(bigInteger1.add(bigInteger2));
    }

    private static String plus(String first, String second) {
        // a와 b를 역순으로 배열에 담는다.
        int length = Math.max(first.length(), second.length());
        int[] a = new int[length+1];
        int[] b = new int[length+1];
        int[] c = new int[length+1];

        int index = 0;
        for(int i=first.length()-1; i>=0; i--){
            a[index] = first.charAt(i) - '0';
            index++;
        }
        index = 0;
        for(int i=second.length()-1; i>=0; i--){
            b[index] = second.charAt(i) - '0';
            index++;
        }
        // a와 b를 더한다.
        for (int i = 0; i < length; i++) {
            c[i] += a[i] + b[i];
            if(c[i] >= 10) {
                c[i+1] = c[i]/10;
                c[i] = c[i]%10;
            }
        }
        // 결과를 역순으로 다시 배열하여 result 값에 담는다.
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=c.length-1; i>=0; i--){
            if(i==c.length-1 && c[i]==0) continue;
            stringBuilder.append(c[i]);
        }
        String result = stringBuilder.toString();
        return result;
    }


}
