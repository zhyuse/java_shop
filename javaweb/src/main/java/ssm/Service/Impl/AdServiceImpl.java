package ssm.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.AdDao;
import ssm.Dao.UserDao;
import ssm.Entity.Ad;
import ssm.Service.AdService;

import java.util.List;
@Service("adService")
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;
    @Override
    public List<Ad> getrand(int num) {
        return adDao.queryadrand(num);
    }
}
