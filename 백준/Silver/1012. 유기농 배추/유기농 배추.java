import java.util.Scanner;

public class Main {
    // 유기농 배추
    // https://www.acmicpc.net/problem/1012
    // 최소 배추흰지렁이 마리 수 출력

    static int xm, yn;
    static int[][] field, check;

    // 동서남북
    int[] dy = {0, 0, 1, -1};
    int[] dx = {-1, 1, 0, 0};


    public void DFS(int y, int x){

        check[y][x] = 1;

        for(int i=0; i<4; i++){ 
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < yn && nx >= 0 && nx < xm && check[ny][nx] == 0){
                if(field[ny][nx] == 1){
                    DFS(ny, nx);
                }
            }
        }

    }

    public static void main(String[] args) {
        Main baechu = new Main();

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tt = 0; tt < t; tt++){
            xm = sc.nextInt(); // 배추밭 가로 길이 x
            yn = sc.nextInt(); // 배추밭 새로 길이 y
            int k = sc.nextInt(); // 배추의 수

            field = new int[yn][xm];
            check = new int[yn][xm];
            for(int j = 0; j< k; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1; // 배추 심기
            }

            int cnt = 0;

            //배추밭 탐색
            for(int y = 0; y < yn; y++){
                for(int x = 0; x < xm; x++){
                    if(field[y][x] == 1 && check[y][x] == 0){
                        baechu.DFS(y, x);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}
