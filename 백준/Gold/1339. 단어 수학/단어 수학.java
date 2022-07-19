import java.util.*;

public class Main {
    // 단어 수학 https://www.acmicpc.net/problem/1339

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 알파벳 갯수 계산. 가중치 구하기
        Map<Character, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<str.length(); j++){
                int pow = (int)Math.pow(10, str.length()-1-j);
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+pow);
            }
        }
        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 가중치대로 계산
        int result = 0;
        int value = 9;
        for(Map.Entry<Character, Integer> entry : entryList){
            result += entry.getValue() * value;
            value--;
        }
        System.out.println(result);
    }
}
