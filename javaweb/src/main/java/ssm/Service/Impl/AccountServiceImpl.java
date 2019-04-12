package ssm.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.UserDao;
import ssm.Entity.User;
import ssm.Service.AccountService;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserDao userDao;
    @Override
    public Boolean register(User user) {
        if(userDao.queryuserbyid(user.getUserid())!=null){
            return false;
        }
        else {
            userDao.insertuser(user);
            return true;
        }
    }

    @Override
    public String login(String id, String password) {
        System.out.println("userdao"+userDao);
        if(userDao.queryuserbyid(id)!=null){
            if (userDao.queryuserbyidandpd(id,password)!=null){
                return "登录成功！";
            }
            else {
                return "密码错误！";
            }
        }
        else {
            return "该用户不存在";
        }
    }

    @Override
    public User getUser(String id) {
        return userDao.queryuserbyid(id);
    }

    @Override
    public void update(User user) {
        userDao.updateuser(user);
    }

    @Override
    public boolean yanzheng(String userid) {
        if(userDao.queryuserbyid(userid)!=null){
            return true;
        }
        else {
            return false;
        }
    }
}
