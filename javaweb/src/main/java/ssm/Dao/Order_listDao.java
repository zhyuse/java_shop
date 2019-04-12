package ssm.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssm.Entity.Order_list;

import java.util.List;
@Repository
public interface Order_listDao {
    //order汇总管理员
    @Select("select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order  group by id")
    public List<Order_list> queryall();//查询全部汇总
    @Select("select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order where status=#{status} group by id ")
    public List<Order_list> queryallByStatus(@Param("status") int status);//对应状态汇总

    //order汇总用户
    @Select("select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order where userid=#{userid}  group by id")
    public List<Order_list> queryallByUid(@Param("userid") String userid);
    @Select("select id,time,userid,productname,count(num) as num,sum(price) as price,address,receiver,status,phone from javaweb.order where status=#{status} and userid=#{userid} group by id ")
    public List<Order_list> queryallByUidAndStatus(@Param("userid") String userid,@Param("status") int status);

    //删除
    @Delete("delete from javaweb.order where id=#{id}")
    public void delete(@Param("id") int id);
}
