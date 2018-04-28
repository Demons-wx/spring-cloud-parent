package online.wangxuan.streamhello;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author wangxuan
 * @date 2018/4/26 15:37
 */
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received: " + payload);
    }


}
