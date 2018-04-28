package online.wangxuan.streamhello.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author wangxuan
 * @date 2018/4/28 17:29
 */
@EnableBinding(value = {Sink.class})
@Slf4j
public class SinkReceiver {

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload) {
        log.info("Received: " + payload);
    }
}
