package org.mybatis.jpetstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.mybatis.jpetstore.mapper")
public class JpetstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpetstoreApplication.class, args);
	}

}
