import java.util.ArrayList;
import java.util.List;

public class Main {
    // https://www.acmicpc.net/problem/4673

    public static void main(String[] args) {
        // 셀프넘버 : 생성자가 없는 숫자
        // 만보다 작거나 같은 셀프넘버 모두 출력

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=10000; i++){
            list.add(i);
        }

        for(int i=1; i<=10000; i++){
            int answer = 0;
            if(i<10){
                answer = i+i;
            } else if (i >= 10 && i < 100){
                int one = i / 10;
                int two = i % 10;
                answer = i + one + two;
            } else if (i >= 100 && i < 1000){
                int one = i / 100;
                int two = (i % 100) / 10;
                int three = (i % 100) % 10;
                answer = i + one + two + three;
            } else if (i == 10000) {
                answer = 10001;
            } else {
                int one = i / 1000;
                int two = (i % 1000) / 100;
                int three = (i % 100) / 10;
                int four = (i % 100) % 10;
                answer = i+one+two+three+four;
            }
            if(list.contains(Integer.valueOf(answer))){
                list.remove(Integer.valueOf(answer));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
