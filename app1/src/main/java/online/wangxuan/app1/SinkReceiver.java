package online.wangxuan.app1;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Transformer;

import java.io.IOException;

/**
 * @author wangxuan
 * @date 2018/5/22 10:42
 */
@EnableBinding(value = {Sink.class})
@Slf4j
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message, User.class);
        log.info("Received: " + user);
    }

}
