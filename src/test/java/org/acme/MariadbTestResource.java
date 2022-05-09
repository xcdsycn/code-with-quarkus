package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MariaDBContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用docker来测试
 * @Author lxh
 * @Date 2022/5/3 19:12
 **/
@QuarkusTestResource(MariadbTestResource.Initializer.class)//注册test resource
public class MariadbTestResource {
    public static class Initializer implements QuarkusTestResourceLifecycleManager { // 定义testResource接口
        private MariaDBContainer mariaDBContainer; // 设置mariadb容器对象


        @Override
        public Map<String, String> start() {
            this.mariaDBContainer = new MariaDBContainer("mariadb:10.4.4");// From 容器
            this.mariaDBContainer.start(); // 启动容器，等待连接
            return getConfigurationParameters(); // 覆盖quarkus的配置，将数据库连接指向容器
        }

        private Map<String, String> getConfigurationParameters() {
            final Map<String, String> conf = new HashMap<>();
            conf.put("quarkus.datasource.url", this.mariaDBContainer.getJdbcUrl());
            conf.put("quarkus.datasource.username", this.mariaDBContainer.getUsername());
            conf.put("quarkus.datasource.password", this.mariaDBContainer.getPassword());
            conf.put("quarkus.datasource.driver", this.mariaDBContainer.getDriverClassName());
            return conf;
        }

        @Override
        public void stop() {
            if(this.mariaDBContainer != null) {
                // 停止容器
                this.mariaDBContainer.close();
            }
        }
    }
}
