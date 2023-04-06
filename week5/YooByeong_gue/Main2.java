package week5.YooByeong_gue;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    List<Integer> firstAnswers=new ArrayList<>(), secondAnswers=new ArrayList<>(), thirdAnswers=new ArrayList<>();
    public int[] solution(int[] answers) {
        int[] answer = {};
        int first=0, second=0, third=0;
        addAnswers();
        int index=0;
        for(int temp : answers){
            if(index >4) index=0;
            if(firstAnswers.get(index) == temp) first++;
            index++;
        }
        index=0;
        for(int temp : answers){
            if(index >7) index=0;
            if(secondAnswers.get(index) == temp) second++;
            index++;
        }
        index=0;
        for(int temp : answers){
            if(index >9) index=0;
            if(thirdAnswers.get(index) == temp) third++;
            index++;
        }
        int max=first;
        List<Integer> answerList = new ArrayList<>();
        if(max < second) max = second;
        if(max < third) max = third;
        if(max == first) answerList.add(1);
        if(max == second) answerList.add(2);
        if(max == third) answerList.add(3);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addAnswers() {
        for(int i=1;i<6;i++){
            firstAnswers.add(i);
        }
        secondAnswers.add(2);
        secondAnswers.add(1);
        secondAnswers.add(2);
        secondAnswers.add(3);
        secondAnswers.add(2);
        secondAnswers.add(4);
        secondAnswers.add(2);
        secondAnswers.add(5);

        thirdAnswers.add(3);
        thirdAnswers.add(3);
        thirdAnswers.add(1);
        thirdAnswers.add(1);
        thirdAnswers.add(2);
        thirdAnswers.add(2);
        thirdAnswers.add(4);
        thirdAnswers.add(4);
        thirdAnswers.add(5);
        thirdAnswers.add(5);
    }
}
