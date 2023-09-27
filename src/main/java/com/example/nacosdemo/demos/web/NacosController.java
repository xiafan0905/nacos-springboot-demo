package com.example.nacosdemo.demos.web;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class NacosController {

    //通过Nacos的@NacosValue注解设置属性值
    @NacosValue(value = "${test.nacos.name}", autoRefreshed = true)
    private String name;

    @GetMapping("/getNacosConfig")
    public String getNacosConfig() {
        return name;
    }

    //使用@NacosInjected注入Nacos的NamingService实例
    @NacosInjected
    private NamingService namingService;

    @GetMapping("/get")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
