package study.dev.algorithm.programmers;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 문자열을점수로바꾸기 <p>
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
public class 문자열을점수로바꾸기 {

    public static void main(String[] args) {
        System.out.println(solution("1234"));
        System.out.println(solution("-1234"));
    }

    public static int solution(String s) {
        return Integer.parseInt(s);
    }
}
