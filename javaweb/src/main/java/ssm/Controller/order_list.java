package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.Entity.Order_list;
import ssm.Service.Order_listService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "order_list")
public class order_list {
    @Autowired
    private Order_listService order_listService;
    @RequestMapping(path = "all")
    public String getorderlist_all(HttpSession session, Model model){
        List<Order_list> order_lists=order_listService.getall((String)session.getAttribute("userid"));
        if(order_lists.size()==0){
            model.addAttribute("msg_order","你还没有任何订单呢~");
        }
        else {
            session.setAttribute("list_order",order_lists);
        }
        session.setAttribute("myinfo_page","order_list/all");
        return "forward:/page/order_list.jsp";
    }
    @RequestMapping(path = "pay")
    public String getorderlist_pay(HttpSession session,Model model){
        List<Order_list> order_lists=order_listService.getall_pay((String)session.getAttribute("userid"));
        if(order_lists.size()==0){
            model.addAttribute("msg_order","你还没有任何待付款订单呢~");
        }
        else {
            session.setAttribute("list_order",order_lists);
        }
        session.setAttribute("myinfo_page","order_list/pay");
        return "forward:/page/order_list.jsp";
    }
    @RequestMapping(path = "deliver")
    public String getorderlist_deliver(HttpSession session,Model model){
        List<Order_list> order_lists=order_listService.getall_deliver((String)session.getAttribute("userid"));
        if(order_lists.size()==0){
            model.addAttribute("msg_order","你还没有任何待发货订单呢~");
        }
        else {
            session.setAttribute("list_order",order_lists);
        }
        session.setAttribute("myinfo_page","order_list/deliver");
        return "forward:/page/order_list.jsp";
    }
}
