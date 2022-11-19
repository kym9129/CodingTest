import java.util.*;

public class Main {
  public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     
     int n = sc.nextInt();
     int total = sc.nextInt();
     
     int[] coins = new int[n];
     for(int i=0; i<n; i++){
         coins[i] = sc.nextInt();
     }
     
     int answer = solution(n, total, coins);
     
     System.out.println(answer);
  }
  
  public static int solution(int n, int total, int[] coins){
      int len = coins.length;
      int cnt=0;
      for(int i=len-1; i>=0; i--){
          int coin = coins[i];
          if(coin >total) continue;
          
          while(coin<=total){
              total -= coin;
              cnt++;
          }
      }
      
      return cnt;
  }
    
}
