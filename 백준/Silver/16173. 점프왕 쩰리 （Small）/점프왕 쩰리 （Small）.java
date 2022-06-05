import java.util.Scanner;

// https://www.acmicpc.net/problem/16173
public class Main {
    static int n;
    static int[][] board;
    static String answer;
    static int[][] ch;

    public void dfs(Pos pos){
        if(pos.x > n || pos.y > n) {
            return;
        }
        else if(board[pos.x][pos.y] == -1) {
            answer = "HaruHaru";
            return;
        }
        else {
            ch[pos.x][pos.y] = 1;
            int move = board[pos.x][pos.y];
            if(pos.x+move <= n && ch[pos.x+move][pos.y] != 1)
                dfs(new Pos(pos.x+move, pos.y, move));
            if(pos.y+move <= n && ch[pos.x][pos.y+move] != 1)
                dfs(new Pos(pos.x, pos.y+move, move));

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n+1][n+1];
        board = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        Main T = new Main();
        T.dfs(new Pos(1,1, board[1][1]));
        if(answer == null) answer = "Hing";
        System.out.println(answer);
    }

    private static class Pos {
        int x;
        int y;
        int move;

        Pos(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

}

