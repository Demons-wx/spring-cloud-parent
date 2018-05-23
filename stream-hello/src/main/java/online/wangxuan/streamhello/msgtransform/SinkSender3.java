package online.wangxuan.streamhello.msgtransform;

import lombok.extern.log4j.Log4j;
import online.wangxuan.streamhello.integration.SinkSender2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author wangxuan
 * @date 2018/5/21 17:36
 */
@EnableBinding(value = {Sink.class})
@Log4j
public class SinkSender3 {

    @Bean
    @InboundChannelAdapter(value = Sink.INPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timeMessageSource() {
        return () -> new GenericMessage<String>("{\"name\": \"wx\", \"age\": 30}");
    }
}
