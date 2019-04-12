package ssm.Dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ssm.Entity.Address;

import java.util.List;

@Repository
public interface AddressDao {
    //查询

    @Select("select * from address where userid=#{userid}")
    public List<Address> queryAdsByUid(@Param("userid") String userid);//全部
    @Select("select * from address where userid=#{userid} and address=#{address}")
    public Address queryAdsByUidAndAds(@Param("userid") String userid,@Param("address") String address);//单个
    //增加
    @Insert("insert into address values(#{id},#{userid},#{address},#{receiver},#{phone}")
    public void insertAds(Address address);
    //修改
    @Update("update address set address=#{address},receiver=#{receiver},phone=#{phone} where id=#{id} and userid=#{userid}")
    public void updateAds(Address address);
    //删除
    @Delete("delete from address where id=#{id} and userid=#{userid} ")
    public void deleteAds(Address address);
}
