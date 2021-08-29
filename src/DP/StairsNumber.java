package DP;

import java.util.Scanner;

public class StairsNumber {
    public static final int UNDEFINED_FLAG = -1;
    private static int MOD = 1000000000;
    private static int[][] stairsCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        stairsCount = new int[n][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                stairsCount[i][j] = UNDEFINED_FLAG;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += getStairsCount(n, i);

            result %= MOD;
        }

        System.out.println(result);
        sc.close();
    }

    private static int getStairsCount(int n, int curStairNumber) {
        int index = n - 1;
        int curStairNumIdx = curStairNumber;

        if (stairsCount[index][curStairNumIdx] != UNDEFINED_FLAG) return stairsCount[index][curStairNumIdx];

        if (index == 0) {
            return curStairNumber == 0 ? 0 : 1;
        }

        if (curStairNumber == 0) {
            stairsCount[index][curStairNumIdx] = getStairsCount(n - 1, 1);
        } else if (curStairNumber == 9) {
            stairsCount[index][curStairNumIdx] = getStairsCount(n - 1, 8);
        } else {
            stairsCount[index][curStairNumIdx] =
                    getStairsCount(n - 1, curStairNumber - 1)  +
                    getStairsCount(n - 1, curStairNumber + 1);
        }

        stairsCount[index][curStairNumIdx] %= MOD;

        return stairsCount[index][curStairNumIdx];
    }
}
