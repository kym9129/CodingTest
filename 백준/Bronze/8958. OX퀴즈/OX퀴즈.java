import java.util.Scanner;

public class Main {
    // 2022.03.06
    // https://www.acmicpc.net/problem/8958

    public static int[] solution(int n, String[] arr){
        int[] answer = new int[n];
//        System.out.println("n="+n);
//        System.out.println("arr="+ Arrays.toString(arr));

        for(int i = 0; i < n; i++){
            String s = arr[i];
            int cnt = 0;
            int sum = 0;
            for(char ch : s.toCharArray()){
                if(ch == 'O'){
                    cnt++;
                }
                else{
                    cnt = 0;
                }
                sum += cnt;
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }

        for(int x : solution(n, arr)) {
            System.out.println(x);
        }

    }
}
