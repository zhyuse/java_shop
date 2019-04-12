package ssm.Service;

import ssm.Entity.*;

import java.util.List;

public interface Order_listService {
    //查询所有订单汇总
    public List<Order_list> getall();
    public List<Order_list> getall(String userid);
    //查询待支付订单汇总
    public List<Order_list> getall_pay();
    public List<Order_list> getall_pay(String userid);
    //查询待发货订单汇总
    public List<Order_list> getall_deliver();
    public List<Order_list> getall_deliver(String userid);
    //查看待收货订单
    public List<Order_list> getall_receiver();
    public List<Order_list> getall_receiver(String userid);
}
