package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.Entity.Order_detail;
import ssm.Service.AddressService;
import ssm.Service.Order_detailService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "order_detail")
public class order_detail {
    @Autowired
    private Order_detailService order_detailService;
    @Autowired
    private AddressService addressService;
    @RequestMapping(path = "one")
    public String findorder_one(int id, HttpSession session, Model model){
        List<Order_detail> order_detail=order_detailService.getorders(id);
        session.setAttribute("address_order",addressService.choice((String) session.getAttribute("userid"),order_detail.get(0).getAddress()));
        session.setAttribute("order_detail",order_detail);
        session.setAttribute("total",order_detailService.getprice(id));
        session.setAttribute("myinfo_page","order_detail/one?id="+id);
        return "redirect:/page/order_detail.jsp";
    }
    @RequestMapping(path = "submit")
    public String submit_order(String address,HttpSession session){
        String userid=(String)session.getAttribute("userid");
        int id=order_detailService.submit(userid,addressService.choice(userid,address));
        List<Order_detail> order_details=order_detailService.getorders(id);
        session.setAttribute("total",order_detailService.getprice(id));
        session.setAttribute("order_detail",order_details);
        session.setAttribute("address_order",addressService.choice(userid,address));
        session.setAttribute("myinfo_page","order_detail/one?id="+id);
        return "redirect:/page/order_detail.jsp";
    }
}
