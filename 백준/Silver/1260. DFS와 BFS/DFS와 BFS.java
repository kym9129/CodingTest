import java.util.*;

public class Main {
    // https://www.acmicpc.net/problem/1260
    static int n, m, v;
    static int[] check;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public void DFS(int v){
        check[v] = 1;
        sb.append(v).append(" ");
        for(int nextV : graph.get(v)){
            if(check[nextV] == 0){
                if(check[nextV] == 0)
                    DFS(nextV);
            }
        }

    }

    public void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        check[v] = 1;

        while(!q.isEmpty()){
            int currentV = q.poll();
            sb.append(currentV).append(" ");

            for(int nextV : graph.get(currentV)){
                if(check[nextV] == 0){
                    q.offer(nextV);
                    check[nextV] = 1;
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 수
        m = sc.nextInt(); // 간선 수
        v = sc.nextInt(); // 시작 정점

        // 인접리스트 만들기
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }
        check = new int[n+1];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <=n; i++){
            Collections.sort(graph.get(i));
        }

        Main T = new Main();
        check[v] = 1;
        T.DFS(v);
        sb.append("\n");

        check = new int[n+1]; // 체크배열 다시 초기화
        T.BFS(v);
        System.out.println(sb.toString());
    }
}
