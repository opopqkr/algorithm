package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 문자열내마음대로정렬하기 <p>
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
public class 문자열내마음대로정렬하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }

    public static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n))
                return o1.compareTo(o2);
            return o1.charAt(n) - o2.charAt(n);
        }).toArray(String[]::new);
    }
}
