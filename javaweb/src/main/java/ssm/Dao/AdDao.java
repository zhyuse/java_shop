package ssm.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssm.Entity.Ad;

import java.util.List;
@Repository
public interface AdDao {
    //查看
    @Select("select * from ad where id=#{id}")
    public Ad queryadbyid(@Param("id") int id);
    @Select("select * from ad order by rand() limit #{num} ")
    public List<Ad> queryadrand(int num);
}
