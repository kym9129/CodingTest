import java.util.*;

public class Main {
    static int m, n; // 가로 세로
    static int[][] tomato, date;
    static Queue<Pos> q = new LinkedList<>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public void bfs(){
        while(!q.isEmpty()){
            // System.out.println(q.size());
            Pos cp = q.poll();
            for(int i=0; i<dy.length; i++){
                int nx = cp.x+dx[i];
                int ny = cp.y+dy[i];
                
                if(ny>=0 && ny<n && nx>=0 && nx<m && 
                   tomato[ny][nx] == 0){
                       tomato[ny][nx] = 1;
                       q.offer(new Pos(ny, nx));
                       date[ny][nx] = date[cp.y][cp.x] + 1;
                   }
            }
        }
    }
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      m = sc.nextInt();
      n = sc.nextInt();
      
      tomato = new int[n][m];
      date = new int[n][m]; // 익은 날짜 표시
      
      for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
              tomato[i][j] = sc.nextInt();
              // System.out.print(tomato[i][j]);
              if(tomato[i][j] == 1){ 
                  // 익은 토마일 경우 큐에 넣기
                  q.offer(new Pos(i, j));
              }
          }
          // System.out.println();
      }
      
      // bfs 호출
      Main T = new Main();
      T.bfs();
      
      // System.out.println("-----bfs done----");
      
      // date에서 값도츌
      int answer = Integer.MIN_VALUE;
      for(int i=0; i<date.length; i++){
          for(int j=0; j<date[i].length; j++){
              
              if(tomato[i][j] == 0){
                  System.out.println(-1);
                  return;
              }
              answer = Math.max(answer, date[i][j]);
              
              // System.out.print(tomato[i][j]);
          }
          // System.out.println();
      }
      System.out.println(answer);
      
    }
}

class Pos {
    int y, x;
    public Pos(int y, int x){
        this.y = y;
        this.x = x;
    }
}