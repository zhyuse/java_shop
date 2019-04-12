package ssm.Dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssm.Entity.Product;

import java.util.List;
@Repository
public interface ProductDao {
    //查找分类
    @Select("select * from javaweb.product where fenlei=#{fenlei}")
    public List<Product> queryByFenlei(@Param("fenlei") String fenlei);
    //指定查找
    @Select("select * from javaweb.product where id=#{id}")
    public Product queryById(@Param("id") int id);
    //随机查找
    @Select("select * from javaweb.product order by rand() limit #{num}")
    public List<Product> queryrandByNum(int num);
    @Select("select * from javaweb.product where fenlei=#{fenlei} order by rand() limit #{num}")
    public List<Product> queryrandByNumAndFenlei(int num, @Param("fenlei") String fenlei);
    //模糊查找
    @Select("SELECT * FROM javaweb.product where name like CONCAT('%',#{key},'%')")
    public List<Product> queryabout(String key);
}
