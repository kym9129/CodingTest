import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<dp.length; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
