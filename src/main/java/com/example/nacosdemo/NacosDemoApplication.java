package com.example.nacosdemo;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//使用@NacosPropertySource加载dataId为nacosTest.properties的配置源，并开启自动更新。
@NacosPropertySource(dataId = "nacosTest.properties", type = ConfigType.PROPERTIES, groupId = "nacos", autoRefreshed = true)
public class NacosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }
}
