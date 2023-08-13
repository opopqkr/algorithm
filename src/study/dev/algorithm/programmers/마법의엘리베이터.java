package study.dev.algorithm.programmers;

public class 마법의엘리베이터 {

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(95));  // 반례 CASE
        System.out.println(solution(554)); // 반례 CASE
    }

    public static int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int temp = storey % 10;
            storey /= 10;

            if (temp > 5) {
                answer += 10 - temp;
                storey++;
            } else if (temp == 5) {
                answer += 5;
                if (storey % 10 >= 5) {
                    storey++;
                }
            } else {
                answer += temp;
            }
        }

        return answer;
    }
}
