package online.wangxuan.app2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author wangxuan
 * @date 2018/5/22 10:46
 */
@EnableBinding(value = {Source.class})
@Slf4j
public class SinkSender {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timeMessageSource() {
        return () -> new GenericMessage<String>("{\"name\": \"wx\", \"age\": 30}");
    }
}
