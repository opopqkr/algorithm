package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 공원산책 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})).forEach(i -> System.out.print(i + " "));
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int[] startPoint = findStartPoint(park);
        int x = startPoint[0];
        int y = startPoint[1];

        for (String route : routes) {
            String direction = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            boolean existsObstacle = false;

            switch (direction) {
                case "E":
                    if (y + distance >= 0 && y + distance < park[0].length()) {
                        for (int j = distance; j > 0; j--) {
                            if (park[x].charAt(y + j) == 'X') {
                                existsObstacle = true;
                                break;
                            }
                        }

                        if (!existsObstacle) {
                            y += distance;
                        }
                    }
                    break;
                case "W":
                    if (y - distance >= 0 && y - distance < park[0].length()) {
                        for (int j = distance; j > 0; j--) {
                            if (park[x].charAt(y - j) == 'X') {
                                existsObstacle = true;
                                break;
                            }
                        }

                        if (!existsObstacle) {
                            y -= distance;
                        }
                    }
                    break;
                case "S":
                    if (x + distance >= 0 && x + distance < park.length) {
                        for (int j = distance; j > 0; j--) {
                            if (park[x + j].charAt(y) == 'X') {
                                existsObstacle = true;
                                break;
                            }
                        }

                        if (!existsObstacle) {
                            x += distance;
                        }
                    }
                    break;
                case "N":
                    if (x - distance >= 0 && x - distance < park.length) {
                        for (int j = distance; j > 0; j--) {
                            if (park[x - j].charAt(y) == 'X') {
                                existsObstacle = true;
                                break;
                            }
                        }

                        if (!existsObstacle) {
                            x -= distance;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    private static int[] findStartPoint(String[] park) {
        int[] coordinate = new int[2];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    coordinate[0] = i;
                    coordinate[1] = j;
                    return coordinate;
                }
            }
        }

        return coordinate;
    }
}
