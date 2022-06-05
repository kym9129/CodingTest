import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/20291

    public static Map<String, Integer> getFileMap(String[] files){
        Map<String, Integer> map = new HashMap<>();
        for(String file : files){
            String[] tmp = file.split("\\.");
            map.put(tmp[1], map.getOrDefault(tmp[1], 0)+1);
        }

        return map;
    }

    public static void main(String[] args) {
        // 확장자명 - 갯수
        // 확장자명 사전 순 정렬

        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        String[] files = new String[N];
        for(int i = 0; i < N; i++){
            files[i] = sc.next();
        }
        Map<String, Integer> answer = getFileMap(files);
        Object[] sortedKeys = answer.keySet().toArray();
        Arrays.sort(sortedKeys);
        StringBuilder sb = new StringBuilder();
        for(Object key : sortedKeys){
            String keyStr = String.valueOf(key);
            sb.append(keyStr).append(" ").append(answer.get(keyStr)).append("\n");
        }
        System.out.println(sb);
    }

}
