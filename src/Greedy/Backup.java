package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Backup {
    private static class Data implements Comparable<Data> {
        int left;
        int right;
        int distance;

        Data(int _start, int _end, int _distance) {
            left = _start;
            right = _end;
            distance = _distance;
        }

        @Override
        public int compareTo(Data o) {
            if (this.distance > o.distance) {
                return 1;
            } else if (this.distance < o.distance) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dis = new int[n + 1];
        PriorityQueue<Data> pq = new PriorityQueue<>();

        Data[] point = new Data[100001];

        for(int i = 0; i < 100001; i++){
            point[i] = new Data(0, 0, 0);
        }

        for (int i = 1; i < n + 1; i++) {
            dis[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            pq.offer(new Data(i, i + 1, dis[i + 1] - dis[i]));

            point[i].left = i - 1;
            point[i].right = i + 1;
            point[i].distance = dis[i + 1] - dis[i];
        }

        point[n].left = n - 1;
        point[n].right = n + 1;
        point[n].distance = 0;

        int cnt = 0;
        int totalDistance = 0;

        while (cnt != k) {
            Data curData = pq.poll();

            int cl = curData.left, cr = curData.right;

            if (cl >= 1 && cr <= n && cr == point[cl].right && cl == point[cr].left) {
                totalDistance += curData.distance;
                cnt++;

                int nl = point[cl].left, nr = point[cr].right;

                point[nl].distance = point[nl].distance + point[cr].distance - point[cl].distance;

                curData.distance = point[nl].distance;
                curData.left = nl;
                curData.right = nr;

                pq.offer(curData);

                point[nl].right = nr;
                point[nr].left = nl;
            }
        }

        System.out.println(totalDistance);
    }
}
