package BASIC;

import java.util.Scanner;

public class Ellection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] voters = new int[n];

        for (int i = 0; i < n; i++) {
            voters[i] = sc.nextInt();
        }

        int cnt = 0;
        while (true) {
            int voteMost = -1;
            int voteIdx = -1;

            for (int i = 0; i < voters.length; i++) {
                if (voters[i] >= voteMost) {
                    voteMost = voters[i];
                    voteIdx = i;
                }
            }

            if (voteIdx == 0) {
                break;
            }

            voters[voteIdx]--;
            voters[0]++;
            cnt++;

        }

        System.out.println(cnt);
    }
}