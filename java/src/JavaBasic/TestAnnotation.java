package JavaBasic;/**
 * @Classname TestAnnotation
 * @Description TODO
 * @Date 19-7-1 下午11:25
 * @Created by mao<tianmao818@qq.com>
 */

import java.lang.annotation.*;


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation{
    String value();
}

