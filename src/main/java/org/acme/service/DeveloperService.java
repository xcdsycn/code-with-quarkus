package org.acme.service;

import org.acme.modelp.Developer;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

/**
 * @Description 可以把参数验证加在Service层，这个是CDI的作用域
 * @Author lxh
 * @Date 2022/5/3 16:17
 **/
@ApplicationScoped
public class DeveloperService {
    public void promoteDeveloper(@Valid Developer developer) {

    }
}
