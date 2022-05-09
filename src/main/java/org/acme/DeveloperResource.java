package org.acme;

import io.quarkus.vertx.http.runtime.filters.Filters;

import javax.enterprise.event.Observes;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * @Description 具体的使用方法参见postman
 * @Author lxh
 * @Date 2022/4/30 16:33
 **/
@Path("/developer")
public class DeveloperResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        return Response.created(UriBuilder // 状态码设置201 （created)，以location头作为URI进行创建
                .fromResource(DeveloperResource.class) // 设置资源资源类的路径
                .path(Long.toString(developer.getId())) // 在Location头设置开发者ID
                .build()
                )
                .entity(developer)
                .build();
    }

    /**
     * 这些很重要，在判断是出了什么问题的时候具有重要的参考做用
     *
     *  信息响应： 100~199
     *  成功的答复：200~299
     *  重定向：300~399
     *  客户端错误：400~499
     *  服务器错误：500~599
     */

    public static class Developer {
        static long counter =1;
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void persist() {
            this.id=counter++;
        }
    }

    /**
     * 这是在一个类中的，可以新建一个类，来实现相同的功能
     * 适用于JAX-RS、Servlet、响应式路由
     * @param filters
     */
    public void filters(@Observes Filters filters) {
        filters.register(
                rc->{
                    rc.response().putHeader("V-Header","Header added by VertX Filter");
                    rc.next();
                },10
        );
    }
}
