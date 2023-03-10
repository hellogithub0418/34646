package com.yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.yx.dao")
public class WuyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuyeApplication.class, args);
        System.out.println("服务器访问路径： http://localhost:8888");
    }

}
