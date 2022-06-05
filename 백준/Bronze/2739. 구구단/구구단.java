import java.util.*;

public class Main{
    public static void main(String[] args){
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String answer = "";
        for(int i = 1; i <= 9; i++){
            answer += n + " * " + i + " = " + (n * i) + "\n";
        }
        
        System.out.println(answer);
    }
}