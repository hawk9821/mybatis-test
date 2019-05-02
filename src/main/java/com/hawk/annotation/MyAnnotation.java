package com.hawk.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author zhangdonghao
 * @date 2019/4/20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyAnnotation {
}
