package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RepeatPermutation {

    public static final int INPUT_NUBMER_MAX = 300 * 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] inputs = line.split(" ", 0);

        int startNumber = Integer.parseInt(inputs[0]);
        int p = Integer.parseInt(inputs[1]);

        Queue<Integer> numberQueue = new LinkedList<>();
        boolean[] visited = new boolean[INPUT_NUBMER_MAX];
        for (int i = 0; i < INPUT_NUBMER_MAX; i++) {
            visited[i] = false;
        }

        while (!visited[startNumber]) {
            visited[startNumber] = true;

            numberQueue.add(startNumber);

            int nextNumber = 0;
            while (startNumber != 0) {
                double digit = startNumber % 10;
                startNumber /= 10;

                nextNumber += Math.pow(digit, p);
            }

            startNumber = nextNumber;
        }

        int resultCnt = 0;
        while (!numberQueue.isEmpty()) {
            int poppedNumber = numberQueue.remove();

            if (poppedNumber == startNumber) {
                break;
            }

            resultCnt++;
        }

        System.out.println(resultCnt);
    }
}