package org.acme;

import io.quarkus.test.Mock;
import org.acme.service.GreetingService;

import javax.inject.Named;

/**
 * @Description Mock掉GreetingService
 * 这里要注意，被mock掉的逻辑，应该是继承下来，然后再override掉，这个很重要
 * @Author lxh
 * @Date 2022/5/3 18:43
 **/
@Mock
@Named("MockGreetingService")
public class MockGreetingService extends GreetingService {

    @Override
    public String getGreeting(int age) {
        return "hello world";
    }
}
