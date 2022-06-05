
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/2164
    public static int solution(int n){
        int answer = 0;
        // 1~n 번의 카드 .1번 최상단, n번 최하단
        // 1. poll
        // 2. offer(poll)

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            q.offer(i);
        }

        while(q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }
        return q.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = solution(n);
        System.out.println(answer);
    }
}
