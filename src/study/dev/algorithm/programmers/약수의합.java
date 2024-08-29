package study.dev.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 약수의합 <p>
 * Description :  <p>
 *
 * <pre>
 *  수정일					  수정자				  수정 내용
 *  ---------------           ------------        -----------------
 *  2024-08-29				  cmpark			     최초작성
 *
 *
 * </pre>
 *
 * @author cmpark
 * @version 1.0.0
 * @since 2024-08-29
 */
public class 약수의합 {

    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                set.add(i);
        }

        int answer = 0;
        for (int num : set) {
            answer += num;
        }

        return answer;
    }
}
