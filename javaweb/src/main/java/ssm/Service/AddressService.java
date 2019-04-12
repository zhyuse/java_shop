package ssm.Service;

import ssm.Entity.*;

import java.util.List;

public interface AddressService {
    //查看地址
    public List<Address> getAddress(String userid);

    //修改地址
    public void update(Address address);

    //选定地址
    public Address choice(String userid, String address);
}
