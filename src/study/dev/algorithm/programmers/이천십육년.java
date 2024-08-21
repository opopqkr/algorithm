package study.dev.algorithm.programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Package : study.dev.algorithm.programmers <p>
 * Class   : 이천십육년 <p>
 * Description :  <p>
 *
 * <pre>
 *  수정일					  수정자				  수정 내용
 *  ---------------           ------------        -----------------
 *  2024-08-21				  cmpark			     최초작성
 *
 *
 * </pre>
 *
 * @author cmpark
 * @version 1.0.0
 * @since 2024-08-21
 */
public class 이천십육년 {

    public static void main(String[] args) {
        System.out.println(solution1(5, 24));
        System.out.println(solution2(5, 24));
    }

    public static String solution1(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.name().substring(0, 3);
    }

    public static String solution2(int a, int b) {
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] monthOfDate = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDate = 0;
        for (int i = 0; i < a - 1; i++) {
            totalDate += monthOfDate[i];
        }
        totalDate += (b - 1);

        return dayOfWeek[totalDate % 7];
    }
}
