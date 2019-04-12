package ssm.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ssm.Entity.Order_detail;

import java.util.List;
@Repository
public interface Order_detailDao {
    //查询订单
    @Select("select * from javaweb.order where userid=#{userid} and status=#{status}")
    public List<Order_detail> queryallbyUidAndStatus(@Param("userid") String userid, @Param("status") int status);
    @Select("select * from javaweb.order where status=#{status}")
    public List<Order_detail> queryallbyStatus(@Param("status") int status);
    @Select("select * from javaweb.order where userid=#{userid}")
    public List<Order_detail> queryallbyUid(@Param("userid") String userid);
    @Select("select * from javaweb.order")
    public List<Order_detail> queryall();
   // public Order query(int id);
    @Select("select * from javaweb.order where id=#{id}")
    public List<Order_detail> querybyId(@Param("id") int id);

    //查询金额
    @Select("select sum(price) from javaweb.order where id=#{id}")
    public double queryprice(@Param("id") int id);
    //修改订单
    @Update("update javaweb.order set receiver=#{receiver},phone=#{phone},address=#{address} where id=#{id}")
    public void domain_updateorder(Order_detail order_detail);
    //改变订单状态
    @Update("update javaweb.order set status=#{status} where id=#{id} and userid=#{userid}")
    public void updateorder(Order_detail order,@Param("status") int status);
    //删除订单
    @Insert("insert into javaweb.order values(#{id},#{time},#{userid},#{productid},#{productname}," +
            "#{num},#{danjia},#{price},#{image},#{address},#{receiver},#{status},#{phone})")
    public  void insertorder(Order_detail order);
    //查询订单数
    @Select("SELECT count(*) from (SELECT count(1) FROM javaweb.order GROUP BY id) temp")
    public int getordernum();
}
