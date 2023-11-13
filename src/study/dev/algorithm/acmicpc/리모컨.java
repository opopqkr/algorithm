package study.dev.algorithm.acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 리모컨 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<String> buttons = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        for (int i = 0; i < m; i++) {
            buttons.remove(in.next());
        }

        answer = Math.abs(n - 100);
        dfs("", n, buttons);

        System.out.println(answer);
    }

    private static int answer;

    private static void dfs(String current, int n, ArrayList<String> buttons) {
        if (current.length() > 6) {
            return;
        }

        if (!current.isEmpty()) {
            // 버튼을 입력한 현재의 길이 + (n 까지의 +/- 횟수)
            int count = current.length() + Math.abs(n - Integer.parseInt(current));
            answer = Math.min(answer, count);
        }

        for (int i = 0; i < buttons.size(); i++) {
            dfs(current + buttons.get(i), n, buttons);
        }
    }
}
