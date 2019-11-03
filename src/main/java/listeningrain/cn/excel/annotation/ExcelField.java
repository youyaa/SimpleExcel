package listeningrain.cn.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
    int STRING = 1;
    int INT = 2;
    int LONG = 3;
    int BIGDECIMAL = 4;
    int TIMESTAMP = 5;

    int index() default 0;

    int type() default 1;

    String name() default "";

    String title() default "";
}
