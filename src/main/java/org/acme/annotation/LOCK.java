package org.acme.annotation;

import javax.ws.rs.HttpMethod;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 要理解注解的创建
 * 关于注解的说明：https://blog.csdn.net/yuzongtao/article/details/83306182
 * 定义好的注解以后，就可以使用反射对注解的对象做一些操作
 *
 * @Author lxh
 * @Date 2022/4/30 17:02
 **/
@Target({ElementType.METHOD}) //使用范围
@Retention(RetentionPolicy.RUNTIME)// 注解被保留的阶段
@HttpMethod("LOCK") // 将LOCK HTTP方法绑定到注解上
@Documented // 是否生成javaDoc文档
public @interface LOCK {
}
