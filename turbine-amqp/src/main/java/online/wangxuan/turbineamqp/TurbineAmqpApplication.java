package online.wangxuan.turbineamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineAmqpApplication.class, args);
	}
}
