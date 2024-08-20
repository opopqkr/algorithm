package study.dev.algorithm.programmers;

public class 삼진법뒤집기 {

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(n, 3));

        return Integer.parseInt(sb.reverse().toString(), 3);
    }
}
