package BASIC;

import java.util.Scanner;

public class ChiefNumber {

    public static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] nums = new int[n];

        String[] inputs = sc.nextLine().split(" ", 0);

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int minDiff = INF;
        int chiefNumIdx = 0;

        for (int curNumIdx = 0; curNumIdx < n; curNumIdx++) {
            int diff = 0;

            for (int i = 0; i < n; i++) {
                if (i == curNumIdx) {
                    continue;
                }

                diff += Math.abs(nums[curNumIdx] - nums[i]);
            }

            if (diff < minDiff) {
                minDiff = diff;
                chiefNumIdx = curNumIdx;
            } else if (diff == minDiff && nums[curNumIdx] < nums[chiefNumIdx]) {
                chiefNumIdx = curNumIdx;
            }
        }

        System.out.println(nums[chiefNumIdx]);
    }
}