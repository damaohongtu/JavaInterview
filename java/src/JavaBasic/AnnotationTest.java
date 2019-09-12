package JavaBasic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Classname AnnotationTest
 * @Description 自定义Annotation
 * @Date 19-7-1 下午11:22
 * @Created by mao<tianmao818@qq.com>
 */



public class AnnotationTest {
    @TestAnnotation(value = "测试方法")
    public static void main(String[] args){
        Class c=AnnotationTest.class;
        Method[] methods=c.getDeclaredMethods();
        for (Method method:methods){
            Annotation[] annotations=method.getDeclaredAnnotations();
            for(Annotation annotation:annotations){
                TestAnnotation testAnnotation=(TestAnnotation)annotation;
                System.out.println(testAnnotation.value());
            }
        }
    }
}
