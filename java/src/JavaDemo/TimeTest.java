package JavaDemo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @Author MaoTian
 * @Classname TimeTest
 * @Description TODO
 * @Date 下午1:30 2019/8/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class TimeTest {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.of(2019,8,14);
        DayOfWeek dayOfWeek=localDate.getDayOfWeek();
        LocalDate d1=localDate.plus(10, ChronoUnit.DAYS);
        LocalDate d2=localDate.minus(10, ChronoUnit.DAYS);
        System.out.println(dayOfWeek);
        System.out.println(d1);
        System.out.println(d2);
    }
}
