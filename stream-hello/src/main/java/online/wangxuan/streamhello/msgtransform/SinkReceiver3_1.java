package online.wangxuan.streamhello.msgtransform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author wangxuan
 * @date 2018/5/21 17:42
 */
@EnableBinding(value = {Sink.class})
@Slf4j
public class SinkReceiver3_1 {

    @StreamListener(Sink.INPUT)
    public void receive(User user) {
        log.info("Received3_1: " + user);
    }
}
