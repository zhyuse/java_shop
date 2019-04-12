package ssm.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.CartDao;
import ssm.Dao.Order_detailDao;
import ssm.Entity.Address;
import ssm.Entity.Cart;
import ssm.Entity.Order_detail;
import ssm.Service.Order_detailService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("order_detailService")
public class Order_detailServiceImpl implements Order_detailService {
    @Autowired
    private Order_detailDao order_detailDao;
    @Autowired
    private CartDao cartDao;
    @Override
    public int submit(String userid , Address address) {   //提交全部
        int id=order_detailDao.getordernum()+1;
        Date getDate = Calendar.getInstance().getTime();
        String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getDate);

        List<Cart> cartList=null;
        cartList=cartDao.querycarts(userid);//取出用户购物车信息
        cartDao.deleteallcart(userid);//清空购物车

        for(int i=0;i<cartList.size();i++){
            Order_detail order=new Order_detail(id,nowtime,userid,cartList.get(i).getProductid(),cartList.get(i).getProductname(),
                    cartList.get(i).getNum(),cartList.get(i).getDanjia(),cartList.get(i).getPrice(),cartList.get(i).getImage(),
                    address.getAddress(),address.getReceiver(),1,address.getPhone());
            System.out.println(order);
            order_detailDao.insertorder(order);
        }
        return id;
    }

    @Override
    public void updateorder(int id, String receiver, String phone, String address) {
        List<Order_detail> order_details=order_detailDao.querybyId(id);
        if(order_details.size()>0){
            for(var order_detail:order_details){
                order_detail.setReceiver(receiver);
                order_detail.setPhone(phone);
                order_detail.setAddress(address);
                order_detailDao.domain_updateorder(order_detail);
            }
        }
    }

    @Override
    public double getprice(int id) {
        return order_detailDao.queryprice(id);
    }

    @Override
    public List<Order_detail> getorders(int id) {
        return order_detailDao.querybyId(id);
    }

    @Override
    public List<Order_detail> getall() {
        return order_detailDao.queryall();
    }

    @Override
    public List<Order_detail> getall(String userid) {
        return order_detailDao.queryallbyUid(userid);
    }

    @Override
    public List<Order_detail> get_paying(String userid) {
        return order_detailDao.queryallbyUidAndStatus(userid,1);
    }

    @Override
    public List<Order_detail> get_paying() {
        return order_detailDao.queryallbyStatus(1);
    }

    @Override
    public void pay(String userid, int id_order) {

    }


    @Override
    public List<Order_detail> get_delivering(String userid) {
        return null;
    }

    @Override
    public List<Order_detail> get_delivering() {
        return order_detailDao.queryallbyStatus(2);
    }

    @Override
    public void deliver(String userid, int id_order) {

    }


    @Override
    public List<Order_detail> get_receiveing(String userid) {
        return null;
    }

    @Override
    public List<Order_detail> get_receiveing() {
        return order_detailDao.queryallbyStatus(3);
    }

    @Override
    public void receive(String userid, int id_order) {

    }

    @Override
    public List<Order_detail> get_commenting(String userid) {
        return null;
    }

    @Override
    public void comment(String userid, int id_order) {
        System.out.println(order_detailDao.getordernum());//测试，可删除
    }


}
