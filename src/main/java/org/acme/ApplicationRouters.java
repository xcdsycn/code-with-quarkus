package org.acme;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * @Description 使用响应式路由，Vert.x的Router实现
 * 参考：https://www.jianshu.com/p/e3a9b63237f9
 *
 * @Author lxh
 * @Date 2022/4/30 17:42
 **/
@ApplicationScoped //将对象实例化到CDI容器，作用域为application
public class ApplicationRouters {
    /**
     * 这个方法是Vert.x自己带的
     * @param router
     */
    public void routes(@Observes Router router) {//提供Route对象用来注册路由
        router.get("/ok") // 请求ok
                .handler(rc -> rc.response().end("好，我是从 Route 来的"));
    }

    /**
     * 这种方式的使用，需要使用quarkus-vertx-web maven 依赖，手动加，使用quarkus扩展加不好用，真不知道为什么要做这个工具，自己加也很容易啊
     * @param routingContext
     */
    @Route(path = "/declarativeok", methods = Route.HttpMethod.GET)
    public void greetings(RoutingContext routingContext) {
        String name = routingContext.request().getParam("name");
        if (name == null) {
            name = "world";
        }
        routingContext.response().end("OK " + name + " 你说对了");
    }
}
