package online.wangxuan.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamHelloApplicationTests {

	@Autowired
	private SinkSender sinkSender;


	@Test
	public void contextLoads() {
	    sinkSender.output().send(MessageBuilder.withPayload("From SinkSender" + new Date()).build());
	}

    @Autowired
    private MessageChannel input;

	@Test
    public void contextLoads2() {
	    input.send(MessageBuilder.withPayload("From MessageChannel").build());
    }
}
