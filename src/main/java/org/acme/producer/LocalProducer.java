package org.acme.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;
import java.util.Locale;

/**
 * @Description 创建工厂类
 * @Author lxh
 * @Date 2022/5/3 17:36
 **/
@ApplicationScoped
public class LocalProducer {
    @Produces
    public Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    @Produces
    @Named("en_US")
    public Locale getEnUSLocale() {
        return Locale.US;
    }

    @Produces
    @Named("es_ES")
    public Locale getEsESLocale() {
        return new Locale("es", "ES");
    }

    /**
     * 自定义的限定符
     */
    @Produces
    @SpainLocale
    public Locale getSpainLocale() {
        return new Locale("es","ES");
    }
}
