package ssm.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ssm.Entity.User;
@Repository
public interface UserDao {
    //注册增加
    @Insert("insert into javaweb.user values(#{userid},#{username},#{password},#{mail})")
    public void insertuser(User user);

    //通过id查找User
    @Select("select * from javaweb.user where userid=#{userid}")
    public User queryuserbyid(@Param("userid") String userid);

    //修改
    @Update("update javaweb.user set username=#{username},password=#{password},mail=#{mail} where userid=#{userid}")
    public void updateuser(User user);

    //判断登录
    @Select("select * from user where userid=#{userid} and password=#{password}")
    public User queryuserbyidandpd(@Param("userid") String userid, @Param("password") String password);
}
