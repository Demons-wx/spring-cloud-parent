package online.wangxuan.rabbitmqhello;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMQ配置类，用来配置队列、交换器、路由等高级信息
 * Created by wx
 * Date: 2018/4/1
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
