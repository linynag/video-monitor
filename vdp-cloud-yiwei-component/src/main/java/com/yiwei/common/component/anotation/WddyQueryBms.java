package com.yiwei.common.component.anotation;

import java.lang.annotation.*;
import java.math.BigDecimal;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface WddyQueryBms {

	int bytelength() default 0;
	double precision() default 1;
	int offset() default 0;
	int sort();
}
