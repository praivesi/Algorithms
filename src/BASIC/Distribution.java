package BASIC;

import java.util.ArrayList;
import java.util.Scanner;

public class Distribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        ArrayList<Integer> results = new ArrayList<>();
        for (int cIter = 0; cIter < c; cIter++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int multi = 1;
            for (int i = 0; i < b; i++) {
                multi *= a;
                multi %= 10;
            }

            int result = multi == 0 ? 10 : multi;

            results.add(result);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
