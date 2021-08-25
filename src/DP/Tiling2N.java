package DP;

import java.util.Scanner;

public class Tiling2N {
    public static final int UNDEFINED_FLAG = -1;
    static int[] tileCounts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            sc.close();

            return;
        }

        tileCounts = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tileCounts[i] = UNDEFINED_FLAG;
        }
        tileCounts[1] = 1;
        tileCounts[2] = 3;

        int result = getTileCount(n);

        System.out.println(result);
        sc.close();
    }

    private static int getTileCount(int n) {
        if (tileCounts[n] != UNDEFINED_FLAG) return tileCounts[n];

        int tileCount1 = getTileCount(n - 1);
        int tileCount2 = getTileCount(n - 2) * 2;

        tileCounts[n] = (tileCount1 + tileCount2) % 10007;

        return tileCounts[n];
    }
}














