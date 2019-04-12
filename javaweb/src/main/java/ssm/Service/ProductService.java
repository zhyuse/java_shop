package ssm.Service;

import ssm.Entity.*;

import java.util.List;

public interface ProductService {
    //查询
    public Product query(int id);//单个
    public List<Product> query(String fenlei);//分类查询
    public List<Product> queryrand(int num);//随机查询

    //修改
    public void update(Product product);//单个修改

    //模糊查询
    public List<Product> queryabout(String keyword);
}
