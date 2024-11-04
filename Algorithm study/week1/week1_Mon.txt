import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // 숫자 입력 받기

        // 길이 구하기
        int len = String.valueOf(Math.abs(n)).length();

        // 각 자릿수의 합의 최대
        int v = (int) Math.pow(10, len - 1);
        int a = (n / v) * v - 1;   
        int sum = 0;
        
        // 각 자릿수의 합 계산
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }

        int m = n - sum;
        boolean flag = true;

        while (m != n) {
            int temp = m;
            sum = 0;
            
            // 각 자릿수의 합 계산
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if ((m + sum) == n) {
                flag = false;
                break;
            }
            m++;
        }

        // 결과 출력
        if (!flag) 
            System.out.println(m);
        else 
            System.out.println(0);

    }
}
