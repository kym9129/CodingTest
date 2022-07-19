import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int[] pr = new int[max+1];
        pr[0] = -1;
        pr[1] = -1;
        for(int i=2; i<=max; i++){
            int j = 2;
            while(i * j <= max){
                pr[i*j] = 1;
                j++;
            }
        }
        int cnt = 0;
        for(int idx : arr){
            if(pr[idx] == 0) cnt++;
        }
        System.out.println(cnt);
    }
}
