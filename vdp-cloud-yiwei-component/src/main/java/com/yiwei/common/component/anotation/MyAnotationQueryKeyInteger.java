package com.yiwei.common.component.anotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface MyAnotationQueryKeyInteger {

	int value() default 0;
}
