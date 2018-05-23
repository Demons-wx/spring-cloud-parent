package online.wangxuan.streamhello.integration;

import lombok.extern.slf4j.Slf4j;
import online.wangxuan.streamhello.MySink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangxuan
 * @date 2018/4/28 17:48
 */
//@EnableBinding(value = {MySink.class})
@Slf4j
public class SinkSender2 {

    @Bean
    @InboundChannelAdapter(value = MySink.INPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

}
