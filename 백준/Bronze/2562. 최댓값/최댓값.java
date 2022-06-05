import java.util.Scanner;

public class Main {

    public static int[] solution(int[] arr){
        int[] answer = new int[2];

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                answer[0] = max;
                answer[1] = i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i = 0 ; i < 9; i++){
            arr[i] = sc.nextInt();
        }

        int[] answer = solution(arr);
        for(int x : answer){
            System.out.println(x);
        }
    }
}
