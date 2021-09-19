package NETWORK_FLOW;

import java.util.LinkedList;
import java.util.Scanner;

public class Cow {
    public static final int INF = 987654321;
    public static int VERTEX_CNT = 52;

    public static LinkedList<Integer> q;
    public static int[] parent;
    public static int[][] capacity;
    public static int[][] flow;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        capacity = new int[VERTEX_CNT][VERTEX_CNT];
        flow = new int[VERTEX_CNT][VERTEX_CNT];
        parent = new int[VERTEX_CNT];

        for (int i = 0; i < VERTEX_CNT; i++) {
            parent[i] = -1;

            for (int j = 0; j < VERTEX_CNT; j++) {
                capacity[i][j] = 0;
                flow[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] splits = input.split(" ", 0);

            int a, b;
            if (splits[0].charAt(0) >= 'A' && splits[0].charAt(0) <= 'Z') {
                a = splits[0].charAt(0) - 'A';
            } else {
                a = splits[0].charAt(0) - 'a' + VERTEX_CNT / 2;
            }

            if (splits[1].charAt(0) >= 'A' && splits[1].charAt(0) <= 'Z') {
                b = splits[1].charAt(0) - 'A';
            } else {
                b = splits[1].charAt(0) - 'a' + VERTEX_CNT / 2;
            }

            capacity[a][b] += Integer.parseInt(splits[2]);
            capacity[b][a] += Integer.parseInt(splits[2]);
        }

        int totAmount = 0;

        while (true) {
            q = new LinkedList<>();

            for(int i = 0; i < VERTEX_CNT; i++){
                parent[i] = -1;
            }

            int source = 'A' - 'A';
            int sink = 'Z' - 'A';

            parent[source] = source;
            q.add(source);


            while (!q.isEmpty() && parent[sink] == -1) {
                int here = q.pop();

                for (int there = 0; there < VERTEX_CNT; there++) {
                    if (capacity[here][there] - flow[here][there] > 0 && parent[there] == -1) {
                        parent[there] = here;
                        q.add(there);
                    }
                }
            }

            if (parent[sink] == -1) break;

            int amount = INF;
            for (int p = sink; p != source; p = parent[p]) {
                amount = Math.min(amount, capacity[parent[p]][p] - flow[parent[p]][p]);
            }

            for (int p = sink; p != source; p = parent[p]) {
                flow[parent[p]][p] += amount;
                flow[p][parent[p]] -= amount;
            }

            totAmount += amount;
        }

        System.out.println(totAmount);

        sc.close();
    }
}
