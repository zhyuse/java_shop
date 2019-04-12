package ssm.Dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ssm.Entity.Cart;

import java.util.List;
@Repository
public interface CartDao {
    //查找cart
    @Select("select * from cart where userid=#{userid} and productid=#{productid}")
    public Cart queryonecart(@Param("userid") String userid,@Param("productid") int productid);
    //查看
    @Select("select * from cart where userid=#{userid}")
    public List<Cart> querycarts(@Param("userid") String userid);
    @Select("select sum(price) from cart where userid=#{userid}")
    public double caluteprice(@Param("userid") String userid);
    //增加
    @Insert("insert into cart values(#{userid},#{productid},#{productname},#{num},#{danjia},#{price},#{image})")
    public void insertcart(Cart cart);
    //删除
    @Delete("delete from cart where userid=#{userid} and productid=#{productid}")
    public void deletecart(Cart cart);
    @Delete("delete from cart where userid=#{userid}")
    public void deleteallcart(@Param("userid") String userid);
    //修改
    @Update("update cart set num=#{num},price=#{price} where productid=#{productid} and userid=#{userid}")
    public void update(Cart cart);
}
