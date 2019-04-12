package ssm.Service;
import ssm.Entity.*;

import java.util.List;

public interface Order_detailService{
    //提交订单
    public int submit(String userid, Address address);//返回id参数
    //修改订单
    public void updateorder(int id,String receiver,String phone,String address);

    public double getprice(int id);  //查询金额
    public List<Order_detail> getorders(int id);//查询订单

    //查询所有订单
    public List<Order_detail> getall();//查询所有订单
    public List<Order_detail> getall(String userid);
    //付款
    public List<Order_detail> get_paying(String userid);//查询待付款订单
    public List<Order_detail> get_paying();//管理员
    /**
     * @param id_order 订单编号
     */
    public void pay(String userid, int id_order);//付款

    //发货
    public List<Order_detail> get_delivering(String userid);//查询待发货订单
    public List<Order_detail> get_delivering();//管理员端
    /**
     * @param id_order 订单编号
     */
    public void deliver(String userid, int id_order);


    //收货
    public List<Order_detail> get_receiveing(String userid);//查询待收货订单
    public List<Order_detail> get_receiveing();
    /**
     * @param id_order 订单编号
     */
    public void receive(String userid, int id_order);

    //评价
    public List<Order_detail> get_commenting(String userid);//查询待评价订单
    /**
     * @param id_order 订单编号
     */
    public void comment(String userid, int id_order);
}
