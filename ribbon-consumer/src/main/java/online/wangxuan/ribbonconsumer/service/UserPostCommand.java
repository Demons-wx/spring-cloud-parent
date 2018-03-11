package online.wangxuan.ribbonconsumer.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import online.wangxuan.ribbonconsumer.entity.User;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wx
 * Date: 2018/3/11
 */
public class UserPostCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private User user;

    public UserPostCommand(RestTemplate restTemplatem, User user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")));
        this.restTemplate = restTemplatem;
        this.user = user;
    }

    @Override
    protected User run() throws Exception {
        // 写操作
        User r = restTemplate.postForObject("http://USER-SERVICE/users", user, User.class);
        // 刷新缓存，清理缓存中失效的User
        UserGetCommand.flushCache(user.getId());

        return r;
    }
}
