package org.acme.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description 使用SPI的方式，配置外置数据源
 * @Author lxh
 * @Date 2022/5/2 21:43
 **/
public class InMemoryConfigSource implements ConfigSource {
    private Map<String,String> prop = new HashMap<>();

    public InMemoryConfigSource() {
        prop.put("greeting.color","red");
    }

    @Override
    public Map<String, String> getProperties() {
        return prop;
    }

    @Override
    public Set<String> getPropertyNames() {
        return prop.keySet();
    }

    /**
     * 配置的重要性，数字越大，优先级越高
     * @return
     */
    @Override
    public int getOrdinal() {
        return 500;
    }

    @Override
    public String getValue(String propertyName) {
        return prop.get(propertyName);
    }

    @Override
    public String getName() {
        return "MemoryConfigSource";
    }
}
