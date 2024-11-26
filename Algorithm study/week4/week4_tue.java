import java.util.*;

public class Main {
	static Integer[] dp;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new Integer[n + 1];
		dp[0] = dp[1] = 0;
		
		System.out.println(find(n));
	}
	
	static int find(int n) {
		if (dp[n] == null) {
            // 3과 2로 나누어 떨어지는 경우
			if (n % 6 == 0) {
				dp[n] = Math.min(find(n-1), Math.min(find(n / 3), find(n / 2))) + 1;
			} else if (n % 3 == 0) { // 3으로 나누어 떨어지는 경우
				dp[n] = Math.min(find(n-1), find(n / 3)) + 1;
			} else if (n % 2 == 0) { // 2로 나누어 떨어지는 경우
				dp[n] = Math.min(find(n-1), find(n / 2)) + 1;
			} else {
				dp[n] = find(n - 1) + 1;
			}
		}
		return dp[n];
	}
}