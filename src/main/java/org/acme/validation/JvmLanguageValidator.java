package org.acme.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 注解的验证方法
 * @Author lxh
 * @Date 2022/5/3 16:30
 **/
public class JvmLanguageValidator implements ConstraintValidator<JvmLanguage,String> {// 定义的注解，用于验证的对象的类型
    /**
     * 检查是否是基于JVM的语音，针对favoriteLanguage的
     */
    private List<String> favoriteLanguages = Arrays.asList("java");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return favoriteLanguages.stream().anyMatch(l -> l.equalsIgnoreCase(value));
    }
}
