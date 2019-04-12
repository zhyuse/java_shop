package ssm.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.CartDao;
import ssm.Dao.ProductDao;
import ssm.Entity.Cart;
import ssm.Entity.Product;
import ssm.Service.CartService;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;
    @Override
    public Cart query(String userid, int productid) {
        return cartDao.queryonecart(userid,productid);
    }

    @Override
    public void insert(String userid, int productid, int num) {
        Product product=productDao.queryById(productid);
        Cart cart=cartDao.queryonecart(userid,productid);
        if(cart==null){
            cartDao.insertcart(new Cart(userid,productid,product.getName(),num,product.getPrice(),
                    num*product.getPrice(),product.getImage())
            );
        }
        else {
            cartDao.update(new Cart(userid,productid,product.getName(),cart.getNum()+num,product.getPrice(),
                    (num+cart.getNum())*product.getPrice(),product.getImage())
            );
        }
    }

    @Override
    public void delete(String userid) {
        cartDao.deleteallcart(userid);
    }

    @Override
    public void delete(Cart cart) {
        cartDao.deletecart(cart);
    }

    @Override
    public List<Cart> getCart(String userid) {
        return cartDao.querycarts(userid);
    }

    @Override
    public double getprice(String userid) {
        return cartDao.caluteprice(userid);
    }
}
