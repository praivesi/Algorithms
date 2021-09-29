package BASIC;

import java.util.Scanner;

public class PictureDiff {
    public static final int INF = 987654321;
    public static final int UNDEFINED = -1;
    static boolean[][][] pictures = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        pictures = new boolean[n][5][7];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                String[] inputs = sc.nextLine().split("", 0);
                for (int k = 0; k < 7; k++) {
                    pictures[i][j][k] = inputs[k].equals("X");
                }
            }
        }

        int pic1 = UNDEFINED, pic2 = UNDEFINED, minDiffCount = INF;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = getDiffCnt(i, j);

                if (cnt < minDiffCount) {
                    minDiffCount = cnt;
                    pic1 = i;
                    pic2 = j;
                }
            }
        }

        System.out.println((pic1 + 1) + " " + (pic2 + 1));
    }

    private static int getDiffCnt(int pic1, int pic2) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (pictures[pic1][i][j] != pictures[pic2][i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
