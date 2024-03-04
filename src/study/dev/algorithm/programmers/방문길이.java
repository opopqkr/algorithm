package study.dev.algorithm.programmers;

import java.util.ArrayList;

public class 방문길이 {

    public static void main(String[] args) {
        // 반례, 역방향
        System.out.println(solution("UDU")); // 1
        System.out.println(solution("UDLRDURL")); // 4

        System.out.println(solution("ULURRDLLU")); // 7
        System.out.println(solution("LULLLLLLU")); // 7
    }

    public static int solution(String dirs) {
        int answer = 0;

        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(new Direction(0, 0, 0, 0));

        for (int i = 0; i < dirs.length(); i++) {
            Direction current = directions.get(directions.size() - 1);
            int nx = current.endX;
            int ny = current.endY;

            switch (dirs.charAt(i)) {
                case 'U':
                    nx += dx[0];
                    break;
                case 'R':
                    ny += dy[1];
                    break;
                case 'D':
                    nx += dx[2];
                    break;
                case 'L':
                    ny += dy[3];
                    break;
                default:
                    break;
            }

            if (nx < -5 || ny < -5 || nx > 5 || ny > 5) continue;

            // 순방향
            Direction forward = new Direction(current.endX, current.endY, nx, ny);
            // 역방향
            Direction reverse = new Direction(nx, ny, current.endX, current.endY);
            if (!directions.contains(forward) && !directions.contains(reverse)) {
                answer++;
            }
            directions.add(reverse);
            // 현재 위치가 역방향이 되지 않도록 순방향을 마지막에 list.add() 해줘야 함.
            directions.add(forward);
        }

        return answer;
    }

    private final static int[] dx = {1, 0, -1, 0};

    private final static int[] dy = {0, 1, 0, -1};

    private static class Direction {
        int startX, startY, endX, endY;

        public Direction(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Direction coordinate = (Direction) o;
            return (this.startX == coordinate.startX && this.startY == coordinate.startY)
                    && (this.endX == coordinate.endX && this.endY == coordinate.endY);
        }
    }
}
