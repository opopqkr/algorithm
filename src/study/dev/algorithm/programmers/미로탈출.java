package study.dev.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
        System.out.println(solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static int solution(String[] maps) {
        char[][] map = createMap(maps);

        Spot start = findCoordinate(map, 'S');
        Spot lever = findCoordinate(map, 'L');
        Spot end = findCoordinate(map, 'E');

        int leverDistance = bfs(start, lever, map, new int[maps.length][maps[0].length()], new boolean[maps.length][maps[0].length()]);
        if (leverDistance == -1) {
            return leverDistance;
        } else {
            int endDistance = bfs(lever, end, map, new int[maps.length][maps[0].length()], new boolean[maps.length][maps[0].length()]);
            if (endDistance == -1) {
                return endDistance;
            } else {
                return leverDistance + endDistance;
            }
        }
    }

    private static int bfs(Spot startSpot, Spot targetSpot, char[][] map, int[][] distance, boolean[][] visited) {
        Queue<Spot> queue = new LinkedList<>();
        queue.offer(startSpot);
        visited[startSpot.x][startSpot.y] = true;

        while (!queue.isEmpty()) {
            Spot current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (map[nx][ny] != 'X' && !visited[nx][ny]) {
                        queue.offer(new Spot(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[current.x][current.y] + 1;
                    }
                }
            }
        }

        if (distance[targetSpot.x][targetSpot.y] == 0) {
            return -1;
        } else {
            return distance[targetSpot.x][targetSpot.y];
        }
    }

    private static Spot findCoordinate(char[][] map, char spotInfo) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == spotInfo) {
                    return new Spot(i, j);
                }
            }
        }
        return null;
    }

    private static char[][] createMap(String[] maps) {
        char[][] mapArray = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            char[] map = maps[i].toCharArray();
            for (int j = 0; j < map.length; j++) {
                mapArray[i][j] = map[j];
            }
        }
        return mapArray;
    }

    private static class Spot {
        int x, y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
