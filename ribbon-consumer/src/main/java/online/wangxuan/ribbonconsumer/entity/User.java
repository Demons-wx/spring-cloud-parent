package online.wangxuan.ribbonconsumer.entity;

/**
 * Created by wx
 * Date: 2018/3/10
 */
public class User {

    private String name;
    private Long id;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
