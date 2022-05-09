package org.acme.interceptor;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 这个是个拦截器，自定义的
 * @Author lxh
 * @Date 2022/5/3 18:13
 **/
@LogEvent
@Interceptor
public class LogEventInterceptor {
    static List<Event> events = new ArrayList<>();

    @AroundInvoke
    public Object logEvent(InvocationContext ctx) throws Exception {
        events.add(new Event(ctx.getMethod().getName(), Arrays.deepToString(ctx.getParameters())));
        return ctx.proceed();
    }
}
