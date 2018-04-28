package online.wangxuan.streamhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author wangxuan
 * @date 2018/4/28 17:18
 */
@Component
public class OutputSender {

    @Autowired @Qualifier("Output-1")
    private MessageChannel output;
}
