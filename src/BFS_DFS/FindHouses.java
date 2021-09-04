package BFS_DFS;

import java.util.*;


public class FindHouses {

    static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int HOUSE_NOT_EXIST = 0;
    public static final int HOUSE_ALREADY_VISIED = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] inputs = line.split("", 0);

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        Queue<House> houseQueue = new LinkedList<>();

        List<Integer> houseCounter = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == HOUSE_NOT_EXIST) continue;
                if (map[i][j] == HOUSE_ALREADY_VISIED) continue;

                houseQueue.add(new House(i, j));

                int houseCnt = 0;

                while (!houseQueue.isEmpty()) {
                    House house = houseQueue.remove();

                    if (house.x < 0 || house.y < 0 || house.x > n - 1 || house.y > n - 1) {
                        continue;
                    }

                    if (map[house.x][house.y] == HOUSE_NOT_EXIST || map[house.x][house.y] == HOUSE_ALREADY_VISIED) {
                        continue;
                    }

                    map[house.x][house.y] = HOUSE_ALREADY_VISIED;

                    houseQueue.add(new House(house.x - 1, house.y));
                    houseQueue.add(new House(house.x + 1, house.y));
                    houseQueue.add(new House(house.x, house.y - 1));
                    houseQueue.add(new House(house.x, house.y + 1));

                    houseCnt++;
                }

                houseCounter.add(houseCnt);
            }
        }

        Collections.sort(houseCounter);

        System.out.println(houseCounter.size());
        for (int i = 0; i < houseCounter.size(); i++) {
            System.out.println(houseCounter.get(i));
        }
    }
}