package study.dev.algorithm.programmers;

import java.util.Arrays;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 나누어떨어지는숫자배열 <p>
 * Description :  <p>
 *
 * <pre>
 *  수정일					  수정자				  수정 내용
 *  ---------------           ------------        -----------------
 *  2024-08-22				  cmpark			     최초작성
 *
 *
 * </pre>
 *
 * @author cmpark
 * @version 1.0.0
 * @since 2024-08-22
 */

public class 나누어떨어지는숫자배열 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0).sorted().toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
