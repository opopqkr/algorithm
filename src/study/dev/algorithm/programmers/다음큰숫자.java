package study.dev.algorithm.programmers;

public class 다음큰숫자 {

    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    private static int solution(int n) {
        // int count = Integer.bitCount(n);
        int count = getBitCount(n);

        int nextBigNum = n + 1;
        while (true) {
            // if (count == Integer.bitCount(nextBigNum))
            if (count == getBitCount(nextBigNum))
                return nextBigNum;
            nextBigNum++;
        }
    }

    private static int getBitCount(int n) {
        int count = 0;

        while (n > 0) {
            int temp = n % 2;
            if (temp == 1) count++;
            n /= 2;
        }

        return count;
    }
}
