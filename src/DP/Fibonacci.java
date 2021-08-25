package DP;

import java.util.Scanner;

public class Fibonacci {
    static int[] fibs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fibs = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            fibs[i] = -1;
        }

        int result = solve(n);

        System.out.println(result);
        sc.close();
    }

    public static int solve(int n) {
        if (n == 0 || n == 1) return n;
        if (fibs[n] != -1) return fibs[n];

        int firstFib = solve(n - 2);
        int secondFib = solve(n - 1);

        if (fibs[n] == -1) {
            fibs[n] = firstFib + secondFib;
        }

        return fibs[n];
    }
}
