package BASIC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Chicken {
    public static void main(String[] args) {
        ArrayList<Integer> results = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {

                String[] inputs = line.split(" ");

                int n = Integer.parseInt(inputs[0]);
                int k = Integer.parseInt(inputs[1]);

                int couponCnt = n;
                while (couponCnt >= k) {
                    couponCnt = couponCnt - k + 1;
                    n++;
                }

                results.add(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
