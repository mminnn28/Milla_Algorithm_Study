import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //삼각수 배열
        int[] tr = new int[45];
        for (int i = 1; i < 45; i++)
            tr[i] = i*(i+1)/2;

        // 갯수 입력 받기
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(findNum(num, tr));
        }    
    }

    public static int findNum(int n, int[] tr) {
        for(int j = 1; j < 45; j++) {
            for (int k = 1; k < 45; k++) {
                for (int s = 1; s < 45; s++) {
                    int sum = tr[j] + tr[k] + tr[s];
                    if (sum == n) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}