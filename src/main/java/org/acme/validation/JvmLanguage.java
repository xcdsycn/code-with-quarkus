package org.acme.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 这个是针对某个属性或者字段的校验，作用的范围，很广
 * @Author lxh
 * @Date 2022/5/3 16:22
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {JvmLanguageValidator.class}) // 将约束条件作为正常的编译错误抛出
public @interface JvmLanguage {
    String message() default "你应该提供一个基于JVM的语言";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
