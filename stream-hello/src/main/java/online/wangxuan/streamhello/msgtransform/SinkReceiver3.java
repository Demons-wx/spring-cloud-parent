package online.wangxuan.streamhello.msgtransform;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

/**
 * @author wangxuan
 * @date 2018/5/21 17:32
 */
//@EnableBinding(value = {Sink.class})
@Log4j
public class SinkReceiver3 {

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(User user) {
        log.info("Received3: " + user);
    }

    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public User transform(String message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message, User.class);
        return user;
    }
}
