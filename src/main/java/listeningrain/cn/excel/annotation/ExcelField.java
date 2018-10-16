package listeningrain.cn.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
	public static final int STRING = 1;
	
	public static final int INT = 2;
	
	public static final int LONG = 3;
	
	public static final int BIGDECIMAL = 4;

	public static final int TIMESTAMP = 5;
	
	int index() default 0;
	
	int type() default 1;

	String name() default "";
	
	String title() default "";
}
