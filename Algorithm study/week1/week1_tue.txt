import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // 키 입력 받기
        int[] height = new int[9];
        for (int i = 0; i < 9; i++)
            height[i] = scanner.nextInt();
        
        // 오름차순 정렬
        Arrays.sort(height);
        //전체 합
        int sum = 0;
        for (int h : height) 
            sum += h;
				/*
				for (int i = 0; i < 9; i++) 
            sum += height[i];
				*/
        
        int i, j, k;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                 if ((sum - height[i] - height[j]) == 100) {
                //출력
                int count = 0; //마지막줄 newLine 안 찍기
                for (k = 0; k < 9; k++)
                    if (k != i && k != j && count != 6) { 
                        System.out.println(height[k]);
                        count++;
                    } else if (k != i && k != j)
                        System.out.print(height[k]);
                return;
                }
            }                  
        }
    }
}