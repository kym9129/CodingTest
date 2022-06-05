import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /* 시간초과 */
    public static String solution4(int[] sg, int[] cards){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : sg){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        // 판정
        for(int card : cards){
            sb.append(map.getOrDefault(card, 0)).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sg = new int[n];
        for(int i = 0; i < n; i++){
            sg[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[m];
        for(int i = 0; i < m; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution4(sg, cards));
    }
}
