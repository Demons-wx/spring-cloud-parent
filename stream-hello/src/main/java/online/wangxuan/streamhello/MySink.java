package online.wangxuan.streamhello;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author wangxuan
 * @date 2018/5/21 15:48
 */
public interface MySink {

    String INPUT = "wangxuan";

    @Input(MySink.INPUT)
    SubscribableChannel input();
}
