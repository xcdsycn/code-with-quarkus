package org.acme;

import io.quarkus.test.junit.NativeImageTest;

/**
 * 原生可执行文件测试，自动生成的
 */
@NativeImageTest // 启动位于 native.image.path的可执行文件
public class NativeGreetingResourceIT extends GreetingResourceTest { // 扩展JVM测试，使其针对可执行文件运行

    // Execute the same tests but in native mode.
}