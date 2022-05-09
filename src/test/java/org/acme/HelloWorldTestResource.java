package org.acme;

import io.quarkus.test.common.QuarkusTestResource;

/**
 * @Description 定义一个专门的空类，用来注册测试的resource
 * @Author lxh
 * @Date 2022/5/3 19:04
 **/
@QuarkusTestResource(HelloWorldQuarkusTestResourceLifeCycleManager.class)
public class HelloWorldTestResource {
}
