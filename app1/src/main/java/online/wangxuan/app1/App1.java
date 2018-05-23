package online.wangxuan.app1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Date;

/**
 * @author wangxuan
 * @date 2018/5/22 9:44
 */
//@EnableBinding(value = {Processor.class})
//@EnableRxJavaProcessor
@Slf4j
public class App1 {

//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
//    public Object receiveFromInput(Object payload) {
//        log.info("Received: " + payload);
//        return "From Input Channel Return - " + payload;
//    }
//
//    @ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
//    public Object receiveFromInput2(Object payload) {
//        log.info("Received2: " + payload);
//        return "From Input Channel Return2 - " + payload;
//    }

//    @Bean
//    public RxJavaProcessor<Date, String> processor() {
//        return inputStream -> inputStream.map(data -> {
//            log.info("Received3: " + data);
//            return data;
//        }).map(data -> String.valueOf("From Input Channel Return3 - " + data));
//    }

//    @Bean
//    public RxJavaProcessor<Date, String> processor() {
//        return inputStream -> inputStream.map(data -> {
//            log.info("Received: " + data);
//            return data;
//        }).buffer(5).map(data -> String.valueOf("From Input Channel Return4 - " + data));
//    }
}
