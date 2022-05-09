package org.acme.exception;

import io.quarkus.arc.Priority;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @Description 用来处理hibernateValidator的验证异常
 * @Author lxh
 * @Date 2022/5/3 16:02
 **/
@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(createErrorMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private JsonArray createErrorMessage(ConstraintViolationException exc) {
        JsonArrayBuilder errors = Json.createArrayBuilder();
        for (ConstraintViolation<?> violation : exc.getConstraintViolations()) {
            errors.add(Json.createObjectBuilder()
                    .add("path", violation.getPropertyPath().toString())
                    .add("message", violation.getMessage())
            );
        }

        return errors.build();
    }
}
