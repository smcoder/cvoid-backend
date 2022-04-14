package org.smcoder.cvoid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.smcoder.cvoid")
public class CvoidBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvoidBackendApplication.class, args);
    }

}
