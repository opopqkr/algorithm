package study.dev.algorithm.programmers;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 문자열다루기기본 <p>
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
public class 문자열다루기기본 {

    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6)
            return false;

        for (char word : s.toCharArray())
            if (!Character.isDigit(word)) return false;

        return true;
    }
}
