package org.acme.config;


import io.quarkus.arc.config.ConfigProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @Description 读取一组值
 * @Author lxh
 * @Date 2022/5/2 22:43
 **/
@ConfigProperties(prefix = "greeting")
public class GreetingConfiguration {
    public String message;
    /**
     * 设置了默认值
     */
    public String suffix = "!";

    @Min(1)
    @Max(3)
    public Integer repeat;

}
