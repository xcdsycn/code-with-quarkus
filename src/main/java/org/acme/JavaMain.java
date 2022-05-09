package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * @Description 配合GreetingMain使用，实现命令行退出
 * @Author lxh
 * @Date 2022/5/4 16:53
 **/
@QuarkusMain
public class JavaMain {
    public static void main(String[] args) {
        Quarkus.run(GreetingMain.class,args);
    }
}
