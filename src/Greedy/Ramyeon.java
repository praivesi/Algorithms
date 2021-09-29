package Greedy;

import java.util.Scanner;

public class Ramyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] ramCnts = new int[n];
        String[] inputs = sc.nextLine().split(" ", 0);

        for (int i = 0; i < n; i++) {
            ramCnts[i] = Integer.parseInt(inputs[i]);
        }

        int charge = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 2) {
                if (ramCnts[i] != 0 && ramCnts[i + 1] != 0) {
                    int min = Math.min(ramCnts[i], ramCnts[i + 1]);

                    ramCnts[i] -= min;
                    ramCnts[i + 1] -= min;
                    charge += 5 * min;
                }

                if (ramCnts[i] != 0) {
                    charge += 3 * ramCnts[i];
                    ramCnts[i] = 0;
                }
            } else if (i == n - 1) {
                if (ramCnts[i] != 0) {
                    charge += 3 * ramCnts[i];
                    ramCnts[i] = 0;
                }
            } else {
                if (ramCnts[i] != 0 && ramCnts[i + 1] != 0 && ramCnts[i + 2] != 0) {
                    int min = Math.min(ramCnts[i], Math.min(ramCnts[i + 1], ramCnts[i + 2]));

                    ramCnts[i] -= min;
                    ramCnts[i + 1] -= min;
                    ramCnts[i + 2] -= min;
                    charge += 7 * min;
                } else if (ramCnts[i] != 0 && ramCnts[i + 1] != 0 && ramCnts[i + 2] == 0) {
                    int min = Math.min(ramCnts[i], ramCnts[i + 1]);

                    ramCnts[i] -= min;
                    ramCnts[i + 1] -= min;
                    charge += 5 * min;
                }

                if (ramCnts[i] != 0) {
                    charge += 3 * ramCnts[i];
                    ramCnts[i] = 0;
                }
            }
        }

        System.out.println(charge);
    }
}
