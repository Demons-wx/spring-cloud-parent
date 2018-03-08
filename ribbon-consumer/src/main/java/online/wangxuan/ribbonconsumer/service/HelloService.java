package online.wangxuan.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangxuan
 * @date 2018/3/7 18:00
 */
@Service
public class HelloService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {

        long start = System.currentTimeMillis();
        String res =  restTemplate.getForEntity("http://HELLO-SERVICE/hello",
                String.class).getBody();
        logger.info("Spend time: " + (System.currentTimeMillis() - start) + "ms");

        return res;
    }

    public String helloFallback() {
        return "error";
    }
}
