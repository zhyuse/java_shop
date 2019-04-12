package ssm.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.AddressDao;
import ssm.Entity.Address;
import ssm.Service.AddressService;

import java.util.List;
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public List<Address> getAddress(String userid) {
        return addressDao.queryAdsByUid(userid);
    }

    @Override
    public void update(Address address) {
        addressDao.updateAds(address);
    }

    @Override
    public Address choice(String userid, String address) {
        return addressDao.queryAdsByUidAndAds(userid,address);
    }
}
