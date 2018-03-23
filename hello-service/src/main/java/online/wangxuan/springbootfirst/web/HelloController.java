package online.wangxuan.springbootfirst.web;



import online.wangxuan.springbootfirst.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
//        int sleepTime = new Random().nextInt(3000);
//        logger.info("sleepTime: " + sleepTime);
//        Thread.sleep(sleepTime);
//
//        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
         return "Hello World";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
