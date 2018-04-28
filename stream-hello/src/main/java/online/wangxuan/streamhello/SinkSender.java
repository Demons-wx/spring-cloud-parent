package online.wangxuan.streamhello;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author wangxuan
 * @date 2018/4/28 16:33
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
