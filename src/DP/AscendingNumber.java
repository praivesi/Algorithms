package DP;

import java.util.Scanner;

public class AscendingNumber {
    public static final int UNDEFINED_FLAG = -1;
    private static int[][] ascendingCounts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ascendingCounts = new int[n + 1][10];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                ascendingCounts[i][j] = UNDEFINED_FLAG;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += getAscendingNumCnt(n, i);
        }

        result %= 10007;

        System.out.println(result);
        sc.close();
    }

    private static int getAscendingNumCnt(int n, int minNumber) {
        if (ascendingCounts[n][minNumber] != UNDEFINED_FLAG) {
            return ascendingCounts[n][minNumber];
        }

        if (n == 1) {
            return 1;
        }

        ascendingCounts[n][minNumber] = 0;
        for (int i = 0; i < minNumber + 1; i++) {
            ascendingCounts[n][minNumber] += getAscendingNumCnt(n - 1, i);
        }

        ascendingCounts[n][minNumber] %= 10007;

        return ascendingCounts[n][minNumber];
    }
}



















