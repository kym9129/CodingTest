import java.io.*;

public class Main {

    public static int solution(int n, int m, int[] sg, int[] sy){
        int answer = 0;
        int p1 = 0, p2 = 0;

        while(p1 < n && p2 < m){
            if(sg[p1] < sy[p2]) p1++;
            else if(sg[p1] > sy[p2]) p2++;
            else {
                answer++;
                p1++;
                p2++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            String testCase = br.readLine();
            if("0 0".equals(testCase)){
                break;
            }
            else{
                String[] temp = testCase.split(" ");
                int n = Integer.parseInt(temp[0]);
                int m = Integer.parseInt(temp[1]);
                int[] sg = new int[n];
                int[] sy = new int[m];
                for(int i = 0; i < n; i++){
                    sg[i] = Integer.parseInt(br.readLine());
                }
                for(int i = 0; i < m; i++){
                    sy[i] = Integer.parseInt(br.readLine());
                }
//                answer += solution(n, m, sg, sy);
                int answer = solution(n, m, sg, sy);
                sb.append(answer+" ");
            }

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
