import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        field = new int [N][N];
        visited = new boolean[N][N];
            
        for (int j = 0; j < N; j++) {
            String input = br.readLine();
            char[] charArray = input.toCharArray();
            for (int i = 0; i < charArray.length; i++) 
                field[j][i] = charArray[i] - '0';
        }
        count();
        
    }

    public static int dfs(int i, int j, int count) {
        visited[i][j] = true;
        // 상
        if (bound(i, j-1) && field[i][j-1] == 1 && visited[i][j-1] == false)
            count = dfs(i, j-1, count+1);
        
        // 하
        if (bound(i, j+1) && field[i][j+1] == 1 && visited[i][j+1] == false) 
            count = dfs(i, j+1, count+1);

        // 좌
        if (bound(i-1, j) && field[i-1][j] == 1 && visited[i-1][j] == false) 
            count = dfs(i-1, j, count+1);

        // 우
        if (bound(i+1, j) && field[i+1][j] == 1 && visited[i+1][j] == false) 
            count = dfs(i+1, j, count+1);
        return count;
    }

    public static void count() {
        int total = 0;
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                if (field[i][j] == 1 && visited[i][j] == false) {
                    total = total + 1;
                    int count = dfs(i, j, 1);
                    list.add(count);
                }
        
        System.out.println(total);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) 
                System.out.print(list.get(i)); 
             else 
                System.out.println(list.get(i));
        }
        
    }

    public static boolean bound(int i, int j) {
       return i >= 0 && i < N && j >= 0 && j < N;
    }
}