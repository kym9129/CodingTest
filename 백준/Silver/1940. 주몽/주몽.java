import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // https://www.acmicpc.net/problem/1940

    public static int solution(int n, int m, int[] a){
        int answer = 0;
        Arrays.sort(a);

        int lt = 0, rt = n-1;
        while(lt < rt){
            int sum = a[lt] + a[rt];
            if(sum < m) lt++;
            else if(sum > m) rt--;
            else{
                answer++;
                lt++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(n, m, a);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
