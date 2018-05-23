package online.wangxuan.streamhello.integration;

import lombok.extern.slf4j.Slf4j;
import online.wangxuan.streamhello.MySink;
import online.wangxuan.streamhello.msgtransform.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangxuan
 * @date 2018/5/21 17:54
 */
//@EnableBinding(value = {MySink.class})
@Slf4j
public class SinkReceiver2_1 {

    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @StreamListener(MySink.INPUT)
    public void receive(Date date) {
        log.info("Received2_1: " + FORMAT.format(date));
    }
}
