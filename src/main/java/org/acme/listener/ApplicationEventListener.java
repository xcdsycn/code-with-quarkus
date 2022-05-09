package org.acme.listener;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * @Description 执行 程序 生命周期事件
 * 必须要加一个Bean注解
 * @Author lxh
 * @Date 2022/5/3 17:44
 **/
@ApplicationScoped
public class ApplicationEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

    /**
     * 启动事件
     * 这个是因为observers的原因，但是确实是启动了以后输出的，不会在关闭输出，这也是约定的一种
     * @param event
     */
    void onStart(@Observes StartupEvent event) {
        logger.info("应用程序 启动中... Application starting...");
    }

    /**
     * 关闭事件
     * @param event
     */
    void onStop(@Observes ShutdownEvent event) {
        logger.info("应用程序关闭中... Application shutting down...");
    }
}
