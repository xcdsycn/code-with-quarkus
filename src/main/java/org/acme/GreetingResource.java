package org.acme;

import org.acme.annotation.LOCK;
import org.acme.config.GreetingConfiguration;
import org.acme.convert.Percentage;
import org.acme.service.GreetingService;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * 这里包含CRUD方法和注解使用等例子
 *
 * @author lxh
 * Path:
 */
@Path("/hello")
public class GreetingResource {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(GreetingResource.class);
    /**
     * 读取自定义属性，在配置文件中
     */
    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.upper-case", defaultValue = "true")
    boolean upperCase;

    public static enum Order {
        desc, asc;
    }

    /**
     * // GET,POST,DELETE,PUT,PATCH,HEAD,OPTIONS: JAX-RS注解
     * produces
     * {@link javax.ws.rs.core.SecurityContext}
     * {@link javax.ws.rs.sse.SseEvent}
     * {@link javax.ws.rs.sse.Sse}
     *
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context UriInfo uriInfo, @QueryParam("order") Order order,
                        @NotBlank @HeaderParam("authorization") String authorization) {
        return String.format((upperCase? message.toUpperCase() : message) + ",URI: %s - Order %s - Authorization: %s", uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String message) {
        System.out.println("create");
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        System.out.println("update");
        return message;
    }

    @DELETE
    public void delete() {
        System.out.println("delete");
    }

    /**
     * 某个注解被绑定到LOCK method 方法上
     *
     * @param id
     * @return
     */
    @LOCK
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id) {
        return id + " locked";
    }

    /**
     * 注入列表
     */
    @ConfigProperty(name = "greeting.suffix")
    List<String> suffixes;

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String HelloList() {
        return message + suffixes.get(1);
    }

    /**
     * 使用编程的方式获取配置的值
     */
    @Inject
    Config config;

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        config.getPropertyNames().forEach(p -> System.out.println(p));
        return config.getValue("greeting.message",String.class);
    }

    @GET
    @Path("/log")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloLog() {
        logger.info("==> this is log of jboss");
        return "hello";
    }

    /**
     * 读取SPI的配置文件，从内存中获取配置，其配置在InMemoryConfigSource中
     */
    @ConfigProperty(name = "greeting.color")
    String color;

    @GET
    @Path("/color")
    @Produces(MediaType.TEXT_PLAIN)
    public String color() {
        return color;
    }

    /**
     * 读取SPI converter配置
     */
    @ConfigProperty(name = "greeting.vat")
    Percentage vat;

    @GET
    @Path("/vat")
    @Produces(MediaType.TEXT_PLAIN)
    public String vat() {
        return Double.toString(vat.getPercentage());
    }

    /**
     * POJO配置
     */
    @Inject
    GreetingConfiguration greetingConfiguration;

    @GET
    @Path("/configurations")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfigurations() {
        return greetingConfiguration.message + greetingConfiguration.suffix;
    }

    @Inject
    GreetingService greetingService;

    @GET
    @Path("/service")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloService() {
       return greetingService.getGreeting(20);
    }
}