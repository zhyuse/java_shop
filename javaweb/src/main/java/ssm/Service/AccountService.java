package ssm.Service;
import ssm.Entity.*;


public interface AccountService {
    //注册
    public Boolean register(User user);
    //登录
    public String login(String id, String password);
    public User getUser(String id);
    //修改资料
    public void update(User user);
    //验证账户存在
    public boolean yanzheng(String userid);
}
