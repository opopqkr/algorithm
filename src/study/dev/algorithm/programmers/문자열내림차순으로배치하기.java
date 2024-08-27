package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 문자열내림차순으로배치하기 <p>
 * Description :  <p>
 *
 * <pre>
 *  수정일					  수정자				  수정 내용
 *  ---------------           ------------        -----------------
 *  2024-08-26				  cmpark			     최초작성
 *
 *
 * </pre>
 *
 * @author cmpark
 * @version 1.0.0
 * @since 2024-08-26
 */
public class 문자열내림차순으로배치하기 {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String[] answer = s.split("");
        Arrays.sort(answer, Comparator.reverseOrder());
        return String.join("", answer);
    }
}
