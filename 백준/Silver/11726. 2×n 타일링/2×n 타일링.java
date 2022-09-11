import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/11726

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_N = 1000;
        final int MODULER = 10007;
        int n = sc.nextInt();

        int[] dp = new int[MAX_N+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % MODULER;
        }

        System.out.println(dp[n]);

    }
}
