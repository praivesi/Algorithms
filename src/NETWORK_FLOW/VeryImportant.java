package NETWORK_FLOW;

import java.util.*;

public class VeryImportant {
    public static final int UNDEFINED = -1;
    public static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>();

        int caseNum = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < caseNum; i++) {
            Map<Integer, ArrayList<Integer>> edges = new HashMap<>();

            String[] inputs = sc.nextLine().split(" ", 0);

            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            int[][] capacity = new int[n][n];
            int[][] pipeCounts = new int[n][n];
            int[][] flow = new int[n][n];
            ArrayList<Integer>[] adjs = new ArrayList[n];

            for (int j = 0; j < n; j++) {
                adjs[j] = new ArrayList<>();

                for (int k = 0; k < n; k++) {
                    capacity[j][k] = 0;
                    pipeCounts[j][k] = 0;
                    flow[j][k] = 0;
                }
            }

            for (int j = 0; j < m; j++) {
                inputs = sc.nextLine().split(" ", 0);

                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int cap = Integer.parseInt(inputs[2]);

                capacity[start - 1][end - 1] += cap;

                pipeCounts[start - 1][end - 1] += 1;

                if (edges.containsKey(start - 1)) {
                    edges.get(start - 1).add(end - 1);
                } else {
                    ArrayList<Integer> newValue = new ArrayList<>();
                    newValue.add(end - 1);

                    edges.put(start - 1, newValue);
                }

                adjs[start - 1].add(end - 1);
            }

            int source = 0;
            int sink = n - 1;

            while (true) {
                int[] parent = new int[n];
                LinkedList<Integer> q = new LinkedList<>();

                for (int j = 0; j < n; j++) {
                    parent[j] = UNDEFINED;
                }

                parent[source] = source;
                q.add(source);

                while (!q.isEmpty() && parent[sink] == UNDEFINED) {
                    int here = q.pop();

                    for (int there = 0; there < n; there++) {
                        if (capacity[here][there] - flow[here][there] > 0 && parent[there] == UNDEFINED) {
                            q.add(there);
                            parent[there] = here;
                        }
                    }
                }

                if (parent[sink] == UNDEFINED) {
                    break;
                }

                int amount = INF;
                for (int p = sink; p != source; p = parent[p]) {
                    amount = Math.min(amount, capacity[parent[p]][p]);
                }

                for (int p = sink; p != source; p = parent[p]) {
                    flow[parent[p]][p] += amount;
                    flow[p][parent[p]] -= amount;
                }
            }

            int importantPipeCount = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> entry : edges.entrySet()) {
                int start = entry.getKey();

                for (int ii = 0; ii < entry.getValue().size(); ii++) {
                    int end = entry.getValue().get(ii);

                    LinkedList<Integer> q = new LinkedList<>();

                    int[] parent = new int[n];

                    for (int j = 0; j < n; j++) {
                        parent[j] = UNDEFINED;
                    }

                    parent[start] = start;
                    q.add(start);

                    while (!q.isEmpty() && parent[end] == UNDEFINED) {
                        int cur = q.pop();

                        for (int next : adjs[cur]) {
                            if (capacity[cur][next] - flow[cur][next] > 0 && parent[next] == UNDEFINED
                                    && capacity[cur][next] != 0) {
                                parent[next] = cur;
                                q.add(next);
                            }
                        }
                    }

                    if (parent[end] == UNDEFINED) {
                        importantPipeCount++;
                    }
                }
            }

            results.add(importantPipeCount);
        }

        for (
                int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

    }
}
