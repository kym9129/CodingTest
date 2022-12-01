import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/1000

    public static int solution(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt(), sc.nextInt()));
    }
}