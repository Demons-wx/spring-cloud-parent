package online.wangxuan.feignconsumer.controller;

import online.wangxuan.feignconsumer.entity.User;
import online.wangxuan.feignconsumer.service.HelloService;
import online.wangxuan.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wx
 * Date: 2018/3/18
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;
    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("wx")).append("\n");
        sb.append(helloService.hello("wx", 25)).append("\n");
        sb.append(helloService.hello(new User("wx", 25))).append("\n");

        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("nimabi")).append("\n");
        sb.append(refactorHelloService.hello("wx", 25)).append("\n");
        sb.append(refactorHelloService.hello(new online.wangxuan.helloserviceapi.entity.User("wx", 25))).append("\n");

        return sb.toString();
    }
}

