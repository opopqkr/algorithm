package study.dev.algorithm.programmers;

public class 점찍기 {

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    public static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += (y / k) + 1;
        }

        return answer;
    }
}
