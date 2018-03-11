package online.wangxuan.ribbonconsumer.service;

import com.netflix.hystrix.HystrixCommand;
import online.wangxuan.ribbonconsumer.entity.User;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * 同步执行：User u = new UserCommand(restTemplate, 1L).execute();
 * 异步执行：Future<User> futureUser = new UserCommand(restTemplate, 1L).queue();
 *
 * 响应式执行方式：
 * Hot Observable：Observable<String> ho = new UserCommand(restTemplate, 1L).observe();
 * Cold Observable：Observable<String> co = new UserCommand(restTemplate, 1L).toObservable();
 *
 * Created by wx
 * Date: 2018/3/10
 */
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    protected UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }

    @Override
    protected User getFallback() {
        return new User();
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }
}
