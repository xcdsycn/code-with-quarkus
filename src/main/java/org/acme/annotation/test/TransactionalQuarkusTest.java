package org.acme.annotation.test;

import io.quarkus.test.junit.QuarkusTest;

import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 组合元注解
 * @Author lxh
 * @Date 2022/5/3 18:54
 **/
@QuarkusTest // 可能继承的注解
@Transactional
@Stereotype // 将注解设置为元注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TransactionalQuarkusTest {
}
