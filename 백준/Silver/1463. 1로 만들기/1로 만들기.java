import java.util.Scanner;

public class Main {

    public int solution(int n){
        int[] d = new int[n+1];
        for(int i=1; i<=n; i++){
            d[i] = i-1;
        }

        for(int i=2; i<=n; i++){
            d[i] = d[i-1] + 1;
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i/3]+1);
            }
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i/2]+1);
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = T.solution(n);
        System.out.println(answer);
    }
}
