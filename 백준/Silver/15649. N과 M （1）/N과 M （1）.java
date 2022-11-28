import java.util.*;

public class Main {
  //  https://st-lab.tistory.com/114 
  public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int m = sc.nextInt();
     
     int[] arr = new int[m];
     boolean[] visited = new boolean[n];
     
     Main T = new Main();
     T.dfs(n, m, arr, visited, 0);
  }
  
  public void dfs(int n, int m, int[] arr, boolean[] visited, int level){
      if(level == m){
          StringBuilder sb = new StringBuilder();
          for(int a : arr){
              sb.append(a).append(" ");
          }
          System.out.println(sb);
          return;
      }
      
      for(int i=0; i<n; i++){
          if(!visited[i]){
              visited[i] = true;
              arr[level] = i+1;
              
              dfs(n, m, arr, visited, level+1);
              
              // 자식노드에서 돌아오면 방문처리 해제
              visited[i] = false;
          }
      }
  }
}
