package org.acme.resource;

import org.acme.modelp.Developer;
import org.glassfish.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description Resource就是当controller用
 * @Author lxh
 * @Date 2022/5/3 11:32
 **/
@Path("/json/developer")
public class DeveloperResource {
    private static final Logger logger = LoggerFactory.getLogger(DeveloperResource.class);
    private static final List<Developer> developers = new ArrayList<>();

    @Inject
    Validator validator;

    /**
     * 使用hibernate validator来验证
     *
     * @param developer
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDeveloper(@Valid Developer developer) {
        logger.info("<-- params: {}", developer);
        developers.add(developer);
        return Response.ok().build();
    }

    /**
     * 一般的JSON请求
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getDevelopers() {
        logger.info("<== response: {}", developers);
        return developers;
    }

    @POST
    @Path("/programmativevalidation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProgrammativeValidation(Developer developer) {
        Set<ConstraintViolation<Developer>> violations = validator.validate(developer);

        if (violations.isEmpty()) {
            System.out.println("==> 验证为空");
            developers.add(developer);
            return Response.ok().build();
        } else {
            JsonArrayBuilder errors = Json.createArrayBuilder();
            for (ConstraintViolation<Developer> violation : violations) {
                errors.add(
                        Json.createObjectBuilder()
                                .add("path", violation.getPropertyPath().toString())
                                .add("message", violation.getMessage())
                );
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(errors.build()).build();
        }
    }
}
