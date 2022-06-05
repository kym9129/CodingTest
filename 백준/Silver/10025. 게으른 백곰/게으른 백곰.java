import java.io.*;

public class Main {

    public static int solution(int n, int k, int[] baskets){
        int answer = 0;
        int lt = 0;
        int len = baskets.length; // 여기 얼마나 해야할지 모르겠다.
        int sum = 0;
        int cnt = 0;
        int maxMove = k * 2 + 1;
        // baskets의 원소를 k*2+1만큼 더해서 가장 큰 값을 출력
        for(int rt = 0; rt < len; rt++){
            sum += baskets[rt];
            cnt++;
            answer = Math.max(answer, sum);
            if(cnt == maxMove){
                sum -= baskets[lt];
                lt++;
                cnt--;
//                if(sum == 0) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        // idx(x)    = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 .... 1000000
        // baskets(g)= _ 5 2 _ _ _ _ 4 _ _  _  _  _  _  _ 10
        //                     엘
        // 엘버트의 총 가용 범위 = k * 2 + 1
        // answer = 5+2+4 = 11

        // idx(x)    = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 .... 1000000
        // baskets(g)= _ 5 2 _ _ _ _ 4 _ _  _  _  _  _  _ 10
        //                                           엘
        // k = 2
        // 엘버트의 총 가용 범위 = k * 2 + 1
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]); // 엘버트 가용 범위

        int[] baskets = new int[1000000];
        for(int i = 0; i < n; i++){
            String[] temp2 = br.readLine().split(" ");
            int g = Integer.parseInt(temp2[0]);
            int x = Integer.parseInt(temp2[1]);
            baskets[x] = g;
        }
        int answer = solution(n, k, baskets);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

}
