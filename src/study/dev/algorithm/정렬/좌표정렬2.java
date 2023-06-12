package study.dev.algorithm.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 좌표정렬2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        ArrayList<Point> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            inputs.add(new Point(x, y));
        }

        Collections.sort(inputs);
        for (Point point : inputs) {
            System.out.println(point.x + " " + point.y);
        }
    }
}

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // compareTo method override 시 에는, return 값이 음수, 0, 양수가 존재.
    // 자기 자신의 변수에서 비교 param object 의 해당 변수를 빼면 오름 차순
    // 비교 param object 의 변수에서 자기 자신을 해당 변수를 빼면 내림 차순
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }

//        if (this.x == o.x) {
//            return o.y - this.y;
//        } else {
//            return o.x - this.x;
//        }
    }
}