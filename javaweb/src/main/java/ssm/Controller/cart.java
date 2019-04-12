package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.Entity.Cart;
import ssm.Service.AddressService;
import ssm.Service.CartService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "cart")
public class cart {
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;

    @RequestMapping(path = "list")
    public String listcart(HttpSession session, Model model){
        if(cartService.getCart((String) session.getAttribute("userid")).size()==0){
            model.addAttribute("msg_cart","当前您的购物车还没有任何商品~");
        }
        else {
            session.setAttribute("total", cartService.getprice((String) session.getAttribute("userid")));
            session.setAttribute("list_cart", cartService.getCart((String) session.getAttribute("userid")));
        }
        return "forward:/page/cart.jsp";
    }
    @RequestMapping(path = "del")
    public String delone(@RequestParam(value = "id_del") int id,HttpSession session){
        Cart cart=cartService.query((String) session.getAttribute("userid"),id);
        System.out.println(cart);
        cartService.delete(cart);
        return "redirect:list";
    }
    @RequestMapping(path = "insert")
    public String insert(@RequestParam(value = "add_id") int id,@RequestParam(value = "add_num") int num,
                         HttpSession session){
        cartService.insert((String)session.getAttribute("userid"),id,num);
        return "redirect:/myinfo/cart";
    }
    @RequestMapping(path = "jiesuan")
    public String jiesuan(HttpSession session){
        session.setAttribute("list_address",addressService.getAddress((String)session.getAttribute("userid")));
        session.setAttribute("total",cartService.getprice((String)session.getAttribute("userid")));
        session.setAttribute("list_cart",cartService.getCart((String) session.getAttribute("userid")));
        session.setAttribute("myinfo_page","cart/jiesuan");
        return "redirect:/page/jiesuan.jsp";
    }
}

