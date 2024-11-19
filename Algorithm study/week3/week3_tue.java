import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            graph[j][k] = true;
            graph[k][j] = true;
        }

        System.out.printf("%d", connectedComponent());
        
    }

     static void dfs (int n) {
       visited[n] = true;
        for (int i = 0; i < N; i++) 
            if (graph[n][i] == true && visited[i] == false)       
                dfs(i);
        return;
    }
    
    static int connectedComponent() {
        int count = 0;
        for (int i = 0; i < N; i++) 
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        return count;      
    }
}