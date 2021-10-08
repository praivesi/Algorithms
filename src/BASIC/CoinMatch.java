package BASIC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoinMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        Collections.sort(coins, Collections.reverseOrder());

        
    }
}
