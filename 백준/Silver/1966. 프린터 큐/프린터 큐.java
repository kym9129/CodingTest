import java.util.*;

public class Main {
    // https://www.acmicpc.net/problem/1966

    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        // m = 몇번째로 인쇄되는지가 궁금한 문서의 현재 idx
        // {idx : 중요도}로 큐에 담기
        Queue<Print> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.offer(new Print(i, arr[i]));
        }

        while(!q.isEmpty()){
            Print tmp = q.poll();
            for(Print p : q){
                if(p.priority > tmp.priority){
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.idx == m) return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0; i<tc; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = sc.nextInt();
            }
            int answer = solution(n, m, arr);
            System.out.println(answer);
        }
    }
}

class Print{
    int idx;
    int priority;

    public Print(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
