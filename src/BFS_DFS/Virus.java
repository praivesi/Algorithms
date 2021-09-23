package BFS_DFS;

import java.util.LinkedList;
import java.util.Scanner;

public class Virus {
    private static boolean[][] adj;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int comCnt = sc.nextInt();
        int edgeCnt = sc.nextInt();
        sc.nextLine();

        adj = new boolean[comCnt][comCnt];
        visited = new boolean[comCnt];

        for (int i = 0; i < comCnt; i++) {
            visited[i] = false;

            for (int j = 0; j < comCnt; j++) {
                adj[i][j] = false;
            }
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] inputs = sc.nextLine().split(" ", 0);

            int a = Integer.parseInt(inputs[0]) - 1;
            int b = Integer.parseInt(inputs[1]) - 1;

            adj[a][b] = true;
            adj[b][a] = true;
        }

        LinkedList<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        int virusComCnt = 0;

        while (!q.isEmpty()) {
            int cur = q.pop();

            for (int i = 0; i < comCnt; i++) {
                if (visited[i]) continue;

                if (adj[cur][i]) {
                    q.add(i);
                    virusComCnt++;

                    visited[i] = true;
                }
            }
        }

        System.out.println(virusComCnt);
    }
}
