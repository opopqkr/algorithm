package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<StringNumber> stringNumbers
                = Arrays.stream(numbers).mapToObj(StringNumber::new).sorted().collect(Collectors.toList());

        if (stringNumbers.get(0).number.equals("0")) {
            return "0";
        }

        for (StringNumber stringNumber : stringNumbers) {
            answer.append(stringNumber.number);
        }

        return answer.toString();
    }

    private static class StringNumber implements Comparable<StringNumber> {
        String number;

        public StringNumber(int number) {
            this.number = Integer.toString(number);
        }

        @Override
        public int compareTo(StringNumber o) {
            return (o.number + this.number).compareTo(this.number + o.number);
        }
    }
}
