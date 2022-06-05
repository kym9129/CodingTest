import java.util.*;

/**
 * 2231번 문제. 분해합
 * https://www.acmicpc.net/problem/2231
 * 
 * 245의 분해합 256(=245+2+4+5). 
 * M(생성자)    N(분해합)
 * 
 * 가장 작은 생성자를 구한다.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		
		int i = 1;
		for(i = 1; i <= N; i++) {
			if(N == getSum(i)) {
				System.out.println(i);
				break;
			}
		}
		if(i > N)
			System.out.println(0);
		
	}
	
		static int getSum(int n) {
			String strN = String.valueOf(n);
			
			int sum = 0;
			for(int i = 0; i < strN.length(); i++) {
				sum += strN.charAt(i) - '0';
			}
			sum += n;
			
			return sum;
		}

}
