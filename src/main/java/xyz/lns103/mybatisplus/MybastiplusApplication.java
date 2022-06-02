package xyz.lns103.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.lns103.mybatisplus.mapper")
public class MybastiplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybastiplusApplication.class, args);
    }

}
