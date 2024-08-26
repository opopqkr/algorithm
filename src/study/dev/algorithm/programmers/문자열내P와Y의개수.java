package study.dev.algorithm.programmers;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 문자열내P와Y의개수 <p>
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
public class 문자열내P와Y의개수 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        int pCount = 0, yCount = 0;

        for (char word : s.toCharArray()) {
            if (Character.toUpperCase(word) == 'P') pCount++;
            if (Character.toUpperCase(word) == 'Y') yCount++;
        }

        return pCount == yCount;
    }
}
