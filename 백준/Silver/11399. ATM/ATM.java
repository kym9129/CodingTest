import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/11399
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int answer = 0;
        for(int i=0; i<N; i++){
            answer += (arr[i] * (N-i));
        }
        System.out.println(answer);
    }
}
