package study.dev.algorithm.programmers;

public class 점프와순간이동 {

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    private static int solution(int n) {
        int answer = 0;

        // 0에서 n까지가 아닌, n에서 0까지 반대로
        while (n != 0) {
            if (n % 2 == 0) { // 2로 나누어 떨어질 경우 순간이동
                n /= 2;
            } else { // 2로 나누어 떨어지지 않을 경우 1칸 씩 이동, 전력 소모
                n -= 1;
                answer++;
            }
        }

        return answer;
    }
}
