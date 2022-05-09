package org.acme;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;

/**
 * @Description 在测试的前后执行代码
 * @Author lxh
 * @Date 2022/5/3 18:59
 **/
public class HelloWorldQuarkusTestResourceLifeCycleManager implements QuarkusTestResourceLifecycleManager {// 必须实现这个接口
    @Override
    public Map<String, String> start() {
        System.out.println("启动 Test Suite 执行");
        return Collections.EMPTY_MAP;
    }

    @Override
    public void stop() {
        System.out.println("终止 Test Suite 执行");
    }

    /**
     * 每执行一个测试类都要调用这个方法
     * @param testInstance
     */
    @Override
    public void inject(Object testInstance) {
        System.out.println("执行 " + testInstance.getClass().getCanonicalName());
    }

    /**
     * 定义多个resource下的执行顺序
     * @return
     */
    @Override
    public int order() {
        return 0;
    }
}
