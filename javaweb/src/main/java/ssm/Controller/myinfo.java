package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "myinfo")
public class myinfo {
    @RequestMapping(path = "cart")
    public String cart(HttpSession session){
        session.setAttribute("myinfo_page","cart/list");
        return "forward:/page/myinfo.jsp";
    }
}
