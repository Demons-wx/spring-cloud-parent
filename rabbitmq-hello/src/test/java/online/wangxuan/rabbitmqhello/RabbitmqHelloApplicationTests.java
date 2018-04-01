package online.wangxuan.rabbitmqhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqHelloApplicationTests {

    @Autowired
    private Sender sender;

	@Test
	public void contextLoads() {
	}

	@Test
    public void hello() throws Exception {

        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int time = random.nextInt(10);
            TimeUnit.SECONDS.sleep(time);
            sender.send();
        }

    }

}
