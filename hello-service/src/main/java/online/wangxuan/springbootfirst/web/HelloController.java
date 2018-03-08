package online.wangxuan.springbootfirst.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * @author wangxuan
 * @date 2018/2/5 19:01
 */

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();

        // 让线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);

        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World";
    }
}
