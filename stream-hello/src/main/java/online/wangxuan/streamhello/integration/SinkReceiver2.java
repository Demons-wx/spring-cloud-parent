package online.wangxuan.streamhello.integration;

import lombok.extern.slf4j.Slf4j;
import online.wangxuan.streamhello.MySink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangxuan
 * @date 2018/4/28 17:29
 */
//@EnableBinding(value = {MySink.class})
@Slf4j
public class SinkReceiver2 {

    @Transformer(inputChannel = MySink.INPUT, outputChannel = MySink.INPUT)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

    @ServiceActivator(inputChannel = MySink.INPUT)
    public void receive(Object payload) {
        log.info("Received2: " + payload);
    }

}
