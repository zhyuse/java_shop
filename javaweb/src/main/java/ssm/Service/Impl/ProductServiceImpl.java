package ssm.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.ProductDao;
import ssm.Entity.Product;
import ssm.Service.ProductService;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product query(int id) {
        return productDao.queryById(id);
    }

    @Override
    public List<Product> query(String fenlei) {
        return productDao.queryByFenlei(fenlei);
    }

    @Override
    public List<Product> queryrand(int num) {
        return productDao.queryrandByNum(num);
    }

    @Override
    public void update(Product product) {

}

    @Override
    public List<Product> queryabout(String keyword) {
        return productDao.queryabout(keyword);
    }
}
