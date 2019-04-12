package ssm.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Dao.Order_listDao;
import ssm.Entity.Order_list;
import ssm.Service.Order_listService;

import java.util.List;
@Service("order_listService")
public class Order_listServiceImpl implements Order_listService {
    @Autowired
    private Order_listDao order_listDao;
    @Override
    public List<Order_list> getall() {
        List<Order_list> order_listList=order_listDao.queryall();
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall(String userid) {
        List<Order_list> order_listList=order_listDao.queryallByUid(userid);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_pay() {
        List<Order_list> order_listList=order_listDao.queryallByStatus(1);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_pay(String userid) {
        List<Order_list> order_listList=order_listDao.queryallByUidAndStatus(userid,1);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_deliver() {
        List<Order_list> order_listList=order_listDao.queryallByStatus(2);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_deliver(String userid) {
        List<Order_list> order_listList=order_listDao.queryallByUidAndStatus(userid,2);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_receiver() {
        List<Order_list> order_listList=order_listDao.queryallByStatus(3);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }

    @Override
    public List<Order_list> getall_receiver(String userid) {
        List<Order_list> order_listList=order_listDao.queryallByUidAndStatus(userid,3);
        if(order_listList.size()==0){
            return order_listList;
        }
        else {
            for (int i=0;i<order_listList.size();i++){
                String productname=order_listList.get(i).getProductname();
                int num=order_listList.get(i).getNum();
                if(order_listList.get(i).getNum()>1){
                    order_listList.get(i).setProductname(productname+"等(共计"+num+"种商品)");
                }
            }
            return order_listList;
        }
    }
}
