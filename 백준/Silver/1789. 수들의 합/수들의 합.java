import java.util.Scanner;

public class Main {
    // 수들의 합
    // https://www.acmicpc.net/problem/1789

    public static long solution(long s){
        long answer = 0;
        long sum = 0;
        for(long i=1; i<=s; i++){
            sum += i;
            if(sum > s){
                answer = i-1;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long answer = s == 1 ? 1 : solution(s);
        System.out.println(answer);
    }
}
