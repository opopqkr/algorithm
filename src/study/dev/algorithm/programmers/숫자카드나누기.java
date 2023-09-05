package study.dev.algorithm.programmers;

public class 숫자카드나누기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcmA = gcmOfArray(arrayA);
        int gcmB = gcmOfArray(arrayB);

        if (gcmA > gcmB) {
            if (!existDivisor(gcmA, arrayB)) {
                answer = Math.max(answer, gcmA);
            }
        } else {
            if (!existDivisor(gcmB, arrayA)) {
                answer = Math.max(answer, gcmB);
            }
        }

        return answer;
    }

    private static boolean existDivisor(int gcm, int[] array) {
        for (int i : array) {
            if (i % gcm == 0) {
                return true;
            }
        }
        return false;
    }

    private static int gcmOfArray(int[] array) {
        int gcm = array[0];
        for (int i = 1; i < array.length; i++) {
            gcm = gcmOfTwoNumber(gcm, array[i]);
        }
        return gcm;
    }

    private static int gcmOfTwoNumber(int smallNumber, int bigNumber) {
        while (smallNumber != 0) {
            int temp = smallNumber;
            smallNumber = bigNumber % smallNumber;
            bigNumber = temp;
        }
        return bigNumber;
    }
}
