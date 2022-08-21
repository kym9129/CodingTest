import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/1929

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int M = sc.nextInt();
        final int N = sc.nextInt();

        int[] arr = new int[N+1];
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i=2; i<=N; i++){
            if(arr[i] == 0){
                primeNumbers.add(i);
            }
            for(int j=i; j<=N; j=j+i){
                arr[j] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int primeNumber : primeNumbers){
            if(primeNumber >= M){
                sb.append(primeNumber).append("\n");
            }
        }
        System.out.println(sb);
    }
}
