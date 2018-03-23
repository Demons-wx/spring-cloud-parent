package online.wangxuan.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by wx
 * Date: 2018/3/18
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends online.wangxuan.helloserviceapi.service.HelloService {
}
