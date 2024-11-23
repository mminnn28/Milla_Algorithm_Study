import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            field = new int [M][N];
            visited = new boolean[M][N];
            
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                field[a][b] = 1;
            }

            if (t == T - 1) {
                System.out.printf("%d", count()); 
            } else {
                System.out.printf("%d\n", count()); 
            }
        }
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        // 상
        if (bound(i, j-1) && field[i][j-1] == 1 && visited[i][j-1] == false)
            dfs(i, j-1);
        
        // 하
        if (bound(i, j+1) && field[i][j+1] == 1 && visited[i][j+1] == false) 
            dfs(i, j+1);

        // 좌
        if (bound(i-1, j) && field[i-1][j] == 1 && visited[i-1][j] == false) 
            dfs(i-1, j);

        // 우
        if (bound(i+1, j) && field[i+1][j] == 1 && visited[i+1][j] == false) 
            dfs(i+1, j);
    }

    public static int count() {
        int count = 0;
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                if (field[i][j] == 1 && visited[i][j] == false) {
                    count = count + 1;
                    dfs(i, j);
                }
        return count;
    }

    public static boolean bound(int i, int j) {
       return i >= 0 && i < M && j >= 0 && j < N;
    }
}