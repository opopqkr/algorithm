package study.dev.algorithm.programmers;

public class 기사단원의무기 {

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
        System.out.println(solution(10, 3, 2));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int numberOfDivisor = countDivisor(i);
            if (numberOfDivisor > limit) {
                numberOfDivisor = power;
            }
            answer += numberOfDivisor;
        }

        return answer;
    }

    private static int countDivisor(int number) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }
        }

        return count;
    }
}
