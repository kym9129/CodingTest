import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // https://www.acmicpc.net/problem/2606
    static int[] unf;

    public int find(int v){
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    public void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        final int COM_NUM = sc.nextInt();
        final int EDGE_NUM = sc.nextInt();

        unf = new int[COM_NUM+1];
        for(int i=1; i<=COM_NUM; i++){
            unf[i] = i;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=COM_NUM; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<EDGE_NUM; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            T.union(a, b);
        }

        // 1번 컴퓨터와 union일 경우 answer++
        int f1 = T.find(1);
        int answer = 0;
        for(int i=2; i<=COM_NUM; i++){
            int fv = T.find(i);
            if(f1 == fv) answer++;
        }
        System.out.println(answer);
    }
}
