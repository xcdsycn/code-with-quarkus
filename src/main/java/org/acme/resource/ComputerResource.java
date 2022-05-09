package org.acme.resource;

import org.acme.modelp.Computer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description XML resource
 * @Author lxh
 * @Date 2022/5/3 12:24
 **/
@Path("/computer")
public class ComputerResource {

    private static final Logger logger = LoggerFactory.getLogger(ComputerResource.class);

    private static final List<Computer> computers = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response addComputer(Computer computer) {
        logger.info("<-- params:{}",computer);
        computers.add(computer);
        return Response.ok().build();
    }

    /**
     * 【重要】返回参数中加了验证，这个防止返回的参数有问题
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public @Valid List<Computer> getComputers() {
        logger.info("<-- response:{}",computers);
        return computers;
    }
}
