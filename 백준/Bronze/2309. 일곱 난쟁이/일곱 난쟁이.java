import java.util.*;

public class Main {
    // https://www.acmicpc.net/problem/2309

    public static List<Integer> findRealDwarfs(List<Integer> dwarfs){
        // 7난쟁이의 키의 합이 100이다.
        // 7난장이를 키의 오름차순으로 출력한다.
        Collections.sort(dwarfs);
        // 7 8 10 13 15 19 20 23 25

        // 가짜난쟁이 조합 경우의 수 9*8 = 72가지..ㄷㄷ
        // 전체 합 - 100 = 가짜난쟁이 키의 합
        // 가짜난쟁이 키의 합이 나오는 조합 찾기

        // 가짜난쟁이 키의 합
        int fakeTotal = -100;
        for(int dwarf : dwarfs){
            fakeTotal += dwarf; // 25+15 = 40
        }

        int tmp1 = 0;
        int tmp2 = 0;
        for(int i = 0; i < dwarfs.size()-1; i++){
            for(int j = i+1; j< dwarfs.size(); j++){
                int sum = dwarfs.get(i) + dwarfs.get(j);
                if(sum == fakeTotal){
                    tmp1 = dwarfs.get(i);
                    tmp2 = dwarfs.get(j);
                    break;
                }
            }

        }
        dwarfs.remove(Integer.valueOf(tmp1));
        dwarfs.remove(Integer.valueOf(tmp2));
        return dwarfs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 9;
        List<Integer> dwarfs = new ArrayList<>();
        for(int i = 0; i < N; i++){
            dwarfs.add(sc.nextInt());
        }

        List<Integer>  answer = findRealDwarfs(dwarfs);
        StringBuilder sb = new StringBuilder();
        for(int x : answer){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
}
