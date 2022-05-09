package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

/**
 * @Description 在命令行模式运行，可以选择在何时退出的程序
 * @Author lxh
 * @Date 2022/5/4 16:47
 **/
public class GreetingMain implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
        System.out.println("----------------------------------");
        System.out.println("这是应用的主程序");
        System.out.println("----------------------------------");
        // 等到quarkus进程停止后退出
        Quarkus.waitForExit();
        return 0;
    }
}
