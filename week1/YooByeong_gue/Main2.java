package week1.YooByeong_gue;

import java.util.HashSet;

public class Main2 {
}
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size() < nums.length/2)
            answer = set.size();
        return answer;
    }
}
