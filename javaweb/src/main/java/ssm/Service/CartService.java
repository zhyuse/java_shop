package ssm.Service;

import ssm.Entity.*;

import java.util.List;


public interface CartService {
    //查询一个cart
    public Cart query(String userid, int productid);

    //添加
    public void insert(String userid, int productid, int num);

    //删除
    public void delete(String userid);
    public void delete(Cart cart);

    //进入结算页面
    public List<Cart> getCart(String userid);

    //查询总金额
    public double getprice(String userid);
}
