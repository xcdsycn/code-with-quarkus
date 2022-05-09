package org.acme.life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 展示生命周期service, 执行  对象 生命周期事件
 * @Author lxh
 * @Date 2022/5/3 17:39
 **/
@ApplicationScoped
public class RecommendationService {
    List<String> products;

    @PostConstruct
    public void init() {
        products = Arrays.asList("桔子","苹果","芒果");
        System.out.println("Products initialized");
    }

    @PreDestroy
    public void cleanup() {
        products =null;
        System.out.println("Products clean up");
    }

    public List<String> getProducts() {
        return products;
    }
}
