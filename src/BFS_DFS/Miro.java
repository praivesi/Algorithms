package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Miro {
    private static class Vertex {
        int n;
        int m;
        int depth;

        public Vertex(int n, int m, int depth) {
            this.n = n;
            this.m = m;
            this.depth = depth;
        }
    }

    private static int N, M;
    private static int[][] miro;
    private static boolean[][] visited;
    private static Queue<Vertex> vertices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] inputs = line.split(" ", 0);

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        miro = new int[N][M];
        visited = new boolean[N][M];
        vertices = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            inputs = line.split("", 0);

            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(inputs[j]);
                visited[i][j] = false;
            }
        }

        vertices.add(new Vertex(1, 1, 1));
        int result = getMinTravel();

        System.out.println(result);
        sc.close();
    }

    private static int getMinTravel() {
        int minDepth = 0;
        while (!vertices.isEmpty()) {
            Vertex v = vertices.remove();

            if (v.n == N && v.m == M) {
                minDepth = v.depth;

                break;
            }

            int nIdx = v.n - 1;
            int mIdx = v.m - 1;

            if (nIdx < 0 || mIdx < 0) continue;
            if (nIdx == N || mIdx == M) continue;

            if (visited[nIdx][mIdx]) continue;
            visited[nIdx][mIdx] = true;

            if (miro[nIdx][mIdx] == 0) continue;

            vertices.add(new Vertex(v.n - 1, v.m, v.depth + 1));
            vertices.add(new Vertex(v.n + 1, v.m, v.depth + 1));
            vertices.add(new Vertex(v.n, v.m - 1, v.depth + 1));
            vertices.add(new Vertex(v.n, v.m + 1, v.depth + 1));
        }

        return minDepth;
    }
}