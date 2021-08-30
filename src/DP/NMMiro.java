package DP;

import java.util.Scanner;

public class NMMiro {
    public static final int UNDEFINED_FLAG = -1;
    private static int[][] maxCandyCount;
    private static int[][] candyCount;

    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] splittedLine = line.split(" ", 0);
        N = Integer.parseInt(splittedLine[0]);
        M = Integer.parseInt(splittedLine[1]);

        maxCandyCount = new int[N][M];
        candyCount = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            splittedLine = line.split(" ", 0);

            for (int j = 0; j < M; j++) {
                candyCount[i][j] = Integer.parseInt(splittedLine[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxCandyCount[i][j] = UNDEFINED_FLAG;
            }
        }

        int result = getMaxCandyCount(1, 1);

        System.out.println(result);
        sc.close();
    }

    private static int getMaxCandyCount(int n, int m) {
        int nIdx = n - 1;
        int mIdx = m - 1;

        if (maxCandyCount[nIdx][mIdx] != UNDEFINED_FLAG) return maxCandyCount[nIdx][mIdx];

        if (n == N && m == M) return candyCount[nIdx][mIdx];

        maxCandyCount[nIdx][mIdx] = candyCount[nIdx][mIdx];

        int nextMax = 0;
        if (n != N && m != M) {
            nextMax = Math.max(nextMax, getMaxCandyCount(n + 1, m));
            nextMax = Math.max(nextMax, getMaxCandyCount(n, m + 1));
            nextMax = Math.max(nextMax, getMaxCandyCount(n + 1, m + 1));
        } else if (n == N && m != M) {
            nextMax = Math.max(nextMax, getMaxCandyCount(n, m + 1));
        } else if (n != N && m == M) {
            nextMax = Math.max(nextMax, getMaxCandyCount(n + 1, m));
        }

        maxCandyCount[nIdx][mIdx] += nextMax;

        return maxCandyCount[nIdx][mIdx];
    }
}