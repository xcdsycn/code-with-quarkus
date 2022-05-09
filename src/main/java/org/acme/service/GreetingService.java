package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.validation.constraints.Min;

/**
 * @Description CDI注入
 * @Author lxh
 * @Date 2022/5/3 17:32
 **/
@ApplicationScoped
// 设置为CDI bean
@Named("greetingService")
public class GreetingService {
    public String getGreeting(@Min(value = 16) int age) {
        if(age<19) {
            return "hello boys and girls";
        } else {
            return "hello, ladies and Gentleman";
        }
    }
}
