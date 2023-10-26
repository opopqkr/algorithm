package study.dev.algorithm.programmers;

public class K진수에서소수개수구하기 {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        // java Integer class 에서 진수 변환 제공
        // 10진수 -> N진수 변환 : Integer.toString(10진수 숫자, 변환할 진수);
        // N진수 -> 10진수 변환 : Integer.parseInt("N진수 문자열", N진수);

        // 문제 적용 시
        // String[] numbers = Integer.toString(n, k).split("0");

        String[] numbers = radix(n, k).split("0");
        for (String number : numbers) {
            if (number.equals("")) continue;
            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }

        return answer;
    }

    private static String radix(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {
            stringBuilder.append(n % k);
            n /= k;
        }

        return stringBuilder.reverse().toString();
    }

    private static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
