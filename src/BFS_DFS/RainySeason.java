package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RainySeason {

    public static class Area {
        int x;
        int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static final int HEIGHT_LIMIT = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] inputs = line.split(" ", 0);

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);

                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSafeAreaCnt = 1;
        for (int i = 1; i < maxHeight; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] != 0) {
                        map[j][k]--;
                    }
                }
            }

            Queue<Area> areaQueue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    visited[j][k] = false;
                }
            }

            int safeAreaCnt = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k]) continue;
                    if (map[j][k] == 0) continue;

                    areaQueue.add(new Area(j, k));

                    while (!areaQueue.isEmpty()) {
                        Area curArea = areaQueue.remove();

                        if (curArea.x < 0 || curArea.y < 0 || curArea.x >= n || curArea.y >= n) continue;
                        if (visited[curArea.x][curArea.y]) continue;
                        if (map[curArea.x][curArea.y] == 0) continue;

                        visited[curArea.x][curArea.y] = true;

                        areaQueue.add(new Area(curArea.x - 1, curArea.y));
                        areaQueue.add(new Area(curArea.x + 1, curArea.y));
                        areaQueue.add(new Area(curArea.x, curArea.y - 1));
                        areaQueue.add(new Area(curArea.x, curArea.y + 1));
                    }

                    safeAreaCnt++;
                }
            }

            maxSafeAreaCnt = Math.max(maxSafeAreaCnt, safeAreaCnt);
        }

        System.out.println(maxSafeAreaCnt);

        sc.close();
    }
}
