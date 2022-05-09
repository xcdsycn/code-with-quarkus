package org.acme.convert;

import io.quarkus.arc.Priority;
import org.eclipse.microprofile.config.spi.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 自定义的类型转换器，要配合SPI使用
 * @Author lxh
 * @Date 2022/5/2 22:26
 **/
@Priority(300)
public class PercentageConverter implements Converter<Percentage> {
    /**
     * LOG4J日志也是可以的
     */
    Logger logger = LoggerFactory.getLogger(PercentageConverter.class);
    @Override
    public Percentage convert(String value) throws IllegalArgumentException, NullPointerException {
        logger.info("--> 读入的属性值：{}", value);
        String numeric = value.substring(0, value.length() -1);
        logger.info("==> 格式化的属性值：{}", numeric);
        return new Percentage(Double.parseDouble(numeric) / 100);
    }
}
