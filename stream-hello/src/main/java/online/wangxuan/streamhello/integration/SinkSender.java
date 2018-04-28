package online.wangxuan.streamhello.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * @author wangxuan
 * @date 2018/4/28 17:48
 */
@EnableBinding(value = {SinkSender.SinkOutput.class})
@Slf4j
public class SinkSender {

    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

    public interface SinkOutput {
        String OUTPUT = "input";
        @Output(SinkOutput.OUTPUT)
        MessageChannel output();
    }
}
