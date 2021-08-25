package DP;

import java.util.Scanner;

public class RemainOne {
    static final int UNDEFINED_FLAG = -1;
    static int[] requiredCounts;
    static final int INF_COUNT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        requiredCounts = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            requiredCounts[i] = UNDEFINED_FLAG;
        }
        requiredCounts[1] = 0;

        int result = getRequiredCount(n);

        System.out.println(result);
        sc.close();
    }

    private static int getRequiredCount(int n) {
        if (requiredCounts[n] != -1) return requiredCounts[n];

        int result1 = n % 3 == 0 ? getRequiredCount(n / 3) : INF_COUNT;
        int result2 = n % 2 == 0 ? getRequiredCount(n / 2) : INF_COUNT;
        int result3 = getRequiredCount(n - 1);

        requiredCounts[n] = Math.min(result1, Math.min(result2, result3)) + 1;

        return requiredCounts[n];
    }
}
