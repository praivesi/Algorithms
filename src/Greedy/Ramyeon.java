package Greedy;

import java.util.Scanner;

public class Ramyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] ramCnts = new int[n];
        String[] inputs = sc.nextLine().split(" ", 0);

        for (int i = 0; i < n; i++) {
            ramCnts[i] = Integer.parseInt(inputs[i]);
        }

        int charge = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 2) {
                if (ramCnts[i] > 0) {
                    ramCnts[i]--;

                    if (ramCnts[i + 1] > 0) {
                        ramCnts[i + 1]--;
                        charge += 5;

                    } else {
                        charge += 3;
                    }
                }
            } else if (i == n - 1) {
                if (ramCnts[i] > 0) {
                    ramCnts[i]--;
                    charge += 3;
                }
            } else {
                if (ramCnts[i] > 0) {
                    ramCnts[i]--;

                    if (ramCnts[i + 1] > 0) {
                        ramCnts[i + 1]--;

                        if (ramCnts[i + 2] > 0) {
                            ramCnts[i + 2]--;
                            charge += 7;

                        } else {
                            charge += 5;
                        }
                    } else {
                        charge += 3;
                    }
                }
            }

            if (ramCnts[i] > 0) {
                i--;
            }


//            if(i == n - 2){
//
//            } else if(i == n - 1){
//
//            } else{
//                if(ramCnts[i] != 0 && ramCnts[i + 1] != 0 && ramCnts[i + 2] != 0){
//
//                }
//            }
        }

        System.out.println(charge);
    }
}
