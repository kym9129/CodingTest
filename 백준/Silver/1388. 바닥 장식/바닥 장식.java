import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/1388

    public static int solution(char[][] floor, int n, int m){
        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char currentWood = floor[i][j];

                if(currentWood == '-'){
                    if((j+1 < m && floor[i][j+1] != currentWood) || j == m-1){
                        answer++;
                    }
                }
                else if(currentWood == '|'){
                    if((i+1 < n && floor[i+1][j] != currentWood) || i == n-1){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] floor = new char[n][m];
        for(int i = 0; i < n; i++){
            String tmp = sc.next();
            for(int j = 0; j < m; j++){
                floor[i][j] = tmp.charAt(j);
            }
        }
        int answer = solution(floor, n, m);
        System.out.println(answer);
    }
}
