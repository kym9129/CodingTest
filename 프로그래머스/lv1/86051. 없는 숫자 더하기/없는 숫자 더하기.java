import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        for(int n : numbers){
            list.remove((Integer)n);
        }

        int answer = 0;
        for(int n : list){
            answer+= n;
        }

        return answer;
    }
}