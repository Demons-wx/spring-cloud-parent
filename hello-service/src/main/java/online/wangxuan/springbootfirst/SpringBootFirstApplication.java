package online.wangxuan.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstApplication.class, args);
	}
}
