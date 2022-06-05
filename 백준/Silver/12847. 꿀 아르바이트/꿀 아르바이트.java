
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // https://www.acmicpc.net/problem/12847

    public static long solution(int n, int m, Long[] a){
        long answer = 0;
        int lt = 0, cnt = 0;
        long sum = 0;
        for(int rt = 0; rt < n; rt++){
            sum += a[rt];
            cnt++;
            if(cnt == m){
                answer = Math.max(answer, sum);
                sum -= a[lt++];
                cnt--;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        Long[] a = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        long answer = solution(n, m, a);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
