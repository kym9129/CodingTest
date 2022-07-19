import java.util.*;

public class Main {

    public boolean checkGroup(String word){

        // 그룹이 아닌 경우
        // 2개 이상의 똑같은 알파벳이 이어져있지 않다.
        Set<Character> set = new HashSet<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if( i-1>=0 && set.contains(ch) && word.charAt(i-1) != ch){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for(int i=0; i<n; i++){
            String word = sc.next();
            boolean group = T.checkGroup(word);
            if(group) cnt++;
        }
        System.out.println(cnt);
    }
}
