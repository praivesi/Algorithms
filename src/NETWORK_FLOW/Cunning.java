package NETWORK_FLOW;

import java.util.Scanner;

public class Cunning {
    public static boolean[][] chairs;
    public static boolean[][] students;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < caseNum; i++) {
            String[] inputs = sc.nextLine().split(" ", 0);
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            chairs = new boolean[n][m];
            students = new boolean[n][m];

            for (int j = 0; j < n; j++) {
                inputs = sc.nextLine().split("", 0);

                for (int k = 0; k < m; k++) {
                    chairs[j][k] = inputs[k] == ".";
                }
            }


        }

    }
}
