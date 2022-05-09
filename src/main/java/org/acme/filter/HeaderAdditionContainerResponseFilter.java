package org.acme.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @Description
 * 这个过滤器只适用于JAX-RS资源，对于响应式路由不适用
 * 区别是，在请求响应式路由的时候，不会出现X-Header头
 * provider必须要加入，不然不会起作用，意思将这个类设置为扩展接口
 * @Author lxh
 * @Date 2022/5/2 11:49
 **/
@Provider
public class HeaderAdditionContainerResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("拦截到响应了");
        // 注意，这里用的是response参数
        containerResponseContext.getHeaders().add("X-Header","Header added by JAXRS ContainerResponseFilter");
    }
}
