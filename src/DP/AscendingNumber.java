package DP;

import java.util.Scanner;

public class AscendingNumber {
    public static final int UNDEFINED_FLAG = -1;
    private static int[][] ascendingCounts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ascendingCounts = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                ascendingCounts[i][j] = UNDEFINED_FLAG;
            }
        }

        int result = getAscendingNumCnt(n, 9);

        System.out.println(result);
        sc.close();
    }

    private static int getAscendingNumCnt(int n, int minNumber) {
        if (n == 1) {
            return minNumber + 1;
        }

        int index = n - 1;

        if (ascendingCounts[index][minNumber] != UNDEFINED_FLAG) {
            return ascendingCounts[index][minNumber];
        }

        ascendingCounts[index][minNumber] = 0;
        for (int i = 0; i < minNumber + 1; i++) {
            ascendingCounts[index][minNumber] += getAscendingNumCnt(n - 1, i);
        }

        ascendingCounts[index][minNumber] %= 10007;

        return ascendingCounts[index][minNumber];
    }
}



















