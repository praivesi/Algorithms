package BFS_DFS;

import java.util.Scanner;

public class PermutationCycle {
    private static int[] permutation;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] results = new int[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine(); // Flush

            String line = sc.nextLine();
            String[] inputs = line.split(" ", 0);

            permutation = new int[n];
            visited = new boolean[n];

            for (int j = 0; j < n; j++) {
                permutation[j] = Integer.parseInt(inputs[j]);
                visited[j] = false;
            }

            int cycleCnt = 0;
            for (int j = 0; j < n; j++) {
                if (visited[j]) continue;

                while (true) {
                    visited[j] = true;

                    int nextIdx = permutation[j] - 1;

                    if (visited[nextIdx]) {
                        cycleCnt++;
                        j = 0;

                        break;
                    }

                    j = nextIdx;
                }
            }

            results[i] = cycleCnt;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(results[i]);
        }

        sc.close();
    }
}