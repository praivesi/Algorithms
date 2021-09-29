package BASIC;

import java.util.ArrayList;
import java.util.Scanner;

public class CandyCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> results = new ArrayList<>();

        for (int cIter = 0; cIter < caseNum; cIter++) {
            sc.nextLine();

            String[] inputs = sc.nextLine().split(" ", 0);

            int r = Integer.parseInt(inputs[0]);
            int c = Integer.parseInt(inputs[1]);

            char[][] box = new char[r][c];

            for (int i = 0; i < r; i++) {
                inputs = sc.nextLine().split("", 0);
                for (int j = 0; j < c; j++) {
                    box[i][j] = inputs[j].charAt(0);
                }
            }

            int candyCnt = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (box[i][j] == '>') {
                        if (j >= c - 2) {
                            continue;
                        }

                        if (box[i][j + 1] == 'o' && box[i][j + 2] == '<') {
                            candyCnt++;
                        }

                    } else if (box[i][j] == 'v') {
                        if (i >= r - 2) {
                            continue;
                        }

                        if (box[i + 1][j] == 'o' && box[i + 2][j] == '^') {
                            candyCnt++;
                        }
                    }
                }
            }

            results.add(candyCnt);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}