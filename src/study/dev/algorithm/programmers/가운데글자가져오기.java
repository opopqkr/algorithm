package study.dev.algorithm.programmers;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 가운데글자가져오기 <p>
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

public class 가운데글자가져오기 {

    public static void main(String[] args) {
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }

    public static String solution(String s) {
        int medium = s.length() / 2;

        return s.length() % 2 == 0 ?
                s.substring(medium - 1, medium + 1) :
                s.substring(medium, medium + 1);
    }
}
