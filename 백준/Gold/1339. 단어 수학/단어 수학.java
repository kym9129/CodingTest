import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 알파벳 갯수 계산. 가중치 구하기
        Map<Character, Integer> map = new TreeMap<>();
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<str.length(); j++){
                int pow = (int)Math.pow(10, str.length()-1-j);
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+pow);
            }
            strs[i] = new StringBuilder(str).reverse().toString();
        }
//        System.out.println(map);
        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//        System.out.println(entryList);

        // 가중치대로 알파벳에 숫자 부여
        Map<Character, Integer> aMap = new HashMap<>();
        int value = 9;
        for(Map.Entry<Character, Integer> entry : entryList){
            aMap.put(entry.getKey(), value);
            value--;
        }
//        System.out.println(aMap);

        // 계산
        int result = 0;
        for(String str : strs){
            for(int j=0; j<str.length(); j++){
                result += aMap.get(str.charAt(j)) * Math.pow(10, j);
            }
        }
        System.out.println(result);
    }
}
