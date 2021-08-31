package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Basic {
    public static final int UNDEFINED_FLAG = -1;
    public static final int EDGE_EXIST = 1;
    private static int N, M;
    private static int[][] adj;
    private static Queue<Integer> bfsQueue;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] inputs = line.split(" ", 0);
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        int startVertex = Integer.parseInt(inputs[2]);

        adj = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adj[i][j] = UNDEFINED_FLAG;
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            line = sc.nextLine();
            inputs = line.split(" ", 0);

            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            adj[a - 1][b - 1] = EDGE_EXIST;
            adj[b - 1][a - 1] = EDGE_EXIST;
        }

        String dfs = DFS(startVertex - 1);

        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }

        bfsQueue = new LinkedList<Integer>();
        bfsQueue.add(startVertex - 1);

        String bfs = BFS();

        System.out.println(dfs);
        System.out.println(bfs);

        sc.close();
    }

    private static String DFS(int curVertexIdx) {
        String travelHistory = (curVertexIdx + 1) + " ";

        visited[curVertexIdx] = true;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (adj[curVertexIdx][i] == UNDEFINED_FLAG) continue;

            travelHistory += DFS(i);
        }

        return travelHistory;
    }

    private static String BFS() {
        String travelHistory = "";

        if (bfsQueue.isEmpty()) return travelHistory;

        while (!bfsQueue.isEmpty()) {
            int curVertexIdx = bfsQueue.remove();

            if (visited[curVertexIdx]) continue;
            visited[curVertexIdx] = true;

            travelHistory += (curVertexIdx + 1) + " ";

            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                if (adj[curVertexIdx][i] == UNDEFINED_FLAG) continue;

                bfsQueue.add(i);
            }
        }

        return travelHistory;
    }
}
