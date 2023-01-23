//https://st-lab.tistory.com/194

import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();
        
        // StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            final int N = sc.nextInt();
            final int M = sc.nextInt();
            
            int answer = combi(M, N);
            // sb.append(answer).append('\n');
            System.out.println(answer);
        }
        // System.out.println(sb);
        
    }
    
    public static int combi(int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }
        
        if(n == r || r == 0){
            return dp[n][r] = 1;
        }
        
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

}