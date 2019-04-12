package ssm.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.Entity.Order_detail;
import ssm.Entity.Order_list;
import ssm.Service.Order_detailService;
import ssm.Service.Order_listService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "domain")
public class domain {
    @Autowired
    private Order_listService order_listService;
    @Autowired
    private Order_detailService order_detailService;
    @RequestMapping(path = "allorder_list")
    public String findallorder_list(Model model, HttpSession session){
        List<Order_list> order_listList=order_listService.getall();
        if(order_listList.size()==0){
            model.addAttribute("msg_order","当前没有任何订单");
        }
        session.setAttribute("list_order",order_listList);
        return "forward:/page/domain_order_list.jsp";
    }
    @RequestMapping(path = "order_pay_list")
    public String findorder_pay_list(Model model, HttpSession session){
        List<Order_list> order_listList=order_listService.getall_pay();
        if(order_listList.size()==0){
            model.addAttribute("msg_order","当前没有任何待付款订单");
        }
        session.setAttribute("list_order",order_listList);
        return "forward:/page/domain_order_list.jsp";
    }
    @RequestMapping(path = "order_deliver_list")
    public String findorder_deliver_list(Model model, HttpSession session){
        List<Order_list> order_listList=order_listService.getall_deliver();
        if(order_listList.size()==0){
            model.addAttribute("msg_order","当前没有任何待发货订单");
        }
        session.setAttribute("list_order",order_listList);
        return "forward:/page/domain_order_list.jsp";
    }
    @RequestMapping(path = "order_receiver_list")
    public String findorder_receiver_list(Model model, HttpSession session){
        List<Order_list> order_listList=order_listService.getall_receiver();
        if(order_listList.size()==0){
            model.addAttribute("msg_order","当前没有任何待收货订单");
        }
        session.setAttribute("list_order",order_listList);
        return "forward:/page/domain_order_list.jsp";
    }
    @RequestMapping(path = "ajax")
    @ResponseBody
    public void ajax(HttpServletResponse response) throws IOException {
        List<Order_list> order_lists= order_listService.getall();
        Gson gson=new Gson();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(gson.toJson(order_lists));
    }
    @RequestMapping(path = "oneorder")
    public String selectorder(@RequestParam(value = "productid") int id, HttpSession session){
        session.setAttribute("order_detail",order_detailService.getorders(id));
        session.setAttribute("total",order_detailService.getprice(id));
        return "redirect:/page/domain_order_detail.jsp";
    }
    @RequestMapping(path = "save")
    public String saveorder(String receiver,String phone,String address,int id,HttpSession session ){
        order_detailService.updateorder(id, receiver, phone, address);
        return "forward:allorder_list";
    }
}
