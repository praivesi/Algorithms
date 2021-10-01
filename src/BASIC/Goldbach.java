package BASIC;

import java.util.ArrayList;
import java.util.Scanner;

public class Goldbach {

    public static final int MILLION = 1000000;
    public static final int UNDEFINED = -1;

    private static class Data {
        int number;
        int primeA;
        int primeB;
        int diff;

        public Data(int _number, int _primeA, int _primeB, int _diff) {
            number = _number;
            primeA = _primeA;
            primeB = _primeB;
            diff = _diff;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] erat = new int[MILLION + 1];

        for (int i = 0; i < MILLION + 1; i++) {
            erat[i] = i;
        }

        erat[0] = UNDEFINED;
        erat[1] = UNDEFINED;

        for (int i = 2; i < Math.sqrt(MILLION); i++) {
            if (erat[i] == UNDEFINED) {
                continue;
            }

            for (int j = i + i; j < MILLION + 1; j += i) {
                erat[j] = UNDEFINED;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < MILLION + 1; i++) {
            if (erat[i] != UNDEFINED) {
                primes.add(erat[i]);
            }
        }

        ArrayList<Data> results = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(sc.nextLine());

            if (n == 0) {
                break;
            }

            int maxDiff = UNDEFINED, primeA = UNDEFINED, primeB = UNDEFINED;
            for (int i = 0; i < primes.size(); i++) {
                int curPrime = primes.get(i);
                int curDiff = n - curPrime;

                if (curDiff < 0) {
                    break;
                }

                if (erat[curDiff] == UNDEFINED) {
                    continue;
                }

                if (curDiff > maxDiff) {
                    maxDiff = Math.max(curDiff, maxDiff);
                    primeA = curPrime;
                    primeB = curDiff;
                }
            }

            results.add(new Data(n, primeA, primeB, maxDiff));
        }

        for (int i = 0; i < results.size(); i++) {
            Data result = results.get(i);

            if (result.diff == UNDEFINED) {
                System.out.println("Goldbach's conjecture is wrong.");
            } else {
                System.out.println(result.number + " = " + result.primeA + " + " + result.primeB);
            }
        }
    }
}