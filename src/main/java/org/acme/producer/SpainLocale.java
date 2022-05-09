package org.acme.producer;

/**
 * @Description 自定义的限定符
 * @Author lxh
 * @Date 2022/5/3 18:05
 **/

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
public @interface SpainLocale {
}
