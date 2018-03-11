package online.wangxuan.ribbonconsumer.service;

import com.netflix.hystrix.HystrixObservableCommand;
import online.wangxuan.ribbonconsumer.entity.User;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by wx
 * Date: 2018/3/10
 */
public class UserObservableCommand extends HystrixObservableCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    public UserObservableCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected Observable<User> construct() {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> obsever) {
                try {
                    if (!obsever.isUnsubscribed()) {
                        User user = restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
                        obsever.onNext(user);
                        obsever.onCompleted();
                    }
                } catch (Exception e) {
                    obsever.onError(e);
                }
            }
        });
    }
}
