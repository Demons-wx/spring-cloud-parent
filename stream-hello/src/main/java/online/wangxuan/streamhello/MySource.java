package online.wangxuan.streamhello;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author wangxuan
 * @date 2018/4/28 17:17
 */
public interface MySource {

    @Output("Output-1")
    MessageChannel output1();

    @Output("Output-2")
    MessageChannel output2();
}
