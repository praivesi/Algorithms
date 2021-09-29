package BASIC;

import java.util.Scanner;

public class MaxNum {

    public static final int SEQ_SIZE = 100;
    public static final int UNDEFINED = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int maxCnt = -1;
        int[] maxSeq = new int[SEQ_SIZE];


        for (int i = 1; i <= num; i++) {
            int[] sequence = new int[SEQ_SIZE];

            sequence[0] = num;
            sequence[1] = i;
            sequence[2] = UNDEFINED;

            int cnt = 2;
            while (true) {
                int curNum = sequence[cnt - 2] - sequence[cnt - 1];
                if (curNum < 0) break;

                sequence[cnt] = curNum;
                sequence[cnt + 1] = UNDEFINED;
                cnt++;
            }

            for (int seqIter = 0; seqIter < SEQ_SIZE; seqIter++) {
                if (sequence[seqIter] == UNDEFINED) {
                    break;
                }
            }

            if (cnt > maxCnt) {
                maxCnt = cnt;
                for (int seqIter = 0; seqIter < SEQ_SIZE; seqIter++) {
                    maxSeq[seqIter] = sequence[seqIter];

                    if (maxSeq[seqIter] == UNDEFINED) {
                        break;
                    }
                }
            }
        }

        System.out.println(maxCnt);
        for (int seqIter = 0; seqIter < SEQ_SIZE; seqIter++) {
            if (maxSeq[seqIter] == UNDEFINED) {
                break;
            }

            System.out.print(maxSeq[seqIter]);

            if (maxSeq[seqIter + 1] != UNDEFINED) {
                System.out.print(" ");
            }
        }
    }
}