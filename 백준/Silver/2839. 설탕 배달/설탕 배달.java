import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/2839
    public int solution(int n){
        final int BIG = 5;
        final int SMALL = 3;
        final int BIG_CNT = n / BIG;
        int minValue = Integer.MAX_VALUE;

        for(int i=0; i<= BIG_CNT; i++){
            int tmp = n-(i*BIG);
            if(tmp % SMALL == 0){
                int tmpCnt = i + tmp / SMALL;
                if(tmpCnt < minValue){
                    minValue = tmpCnt;
                }
            }
        }
        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main M = new Main();
//        int[] arr = {18, 4, 6, 9, 11};
//        for(int n : arr){
            int answer = M.solution(n);
            System.out.println(answer);
//        }
    }
}
