package cn.tiger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("cn.tiger.mapper")
@EnableCaching
public class MDApplication {

	public static void main(String[] args) {
		SpringApplication.run(MDApplication.class, args);
	}
}
