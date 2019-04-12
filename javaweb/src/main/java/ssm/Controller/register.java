package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import snnu.zhyuse.mymail.MyMail;
import ssm.Entity.User;
import ssm.Service.AccountService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(path = "register")
public class register {
    @Autowired
    private AccountService accountService;
    @RequestMapping(path = "step1")
    public String sendmail(HttpSession session,Model model , String userid, String username, String userpd, String usermail){
        MyMail myMail=new MyMail();
        session.setAttribute("yzm",myMail.send(usermail));
        session.setAttribute("user_register",new User(userid,username,userpd,usermail));
        model.addAttribute("step",2);
        return "forward:/page/register.jsp";
    }
    @RequestMapping(path = "step2")
    public String testyzm(String yzm,HttpSession session,Model model){
        if(yzm.equals(session.getAttribute("yzm"))){
            accountService.register((User)session.getAttribute("user_register"));
            model.addAttribute("msg_login","注册成功");
            return "forward:/page/login.jsp";
        }
        else {
            model.addAttribute("msg_register","验证码错误");
            model.addAttribute("step",2);
            return "forward:/page/register.jsp";
        }
    }
    @RequestMapping(path = "ajax")
    @ResponseBody
    public void ajax(String userid, HttpServletResponse response) throws IOException {
        if(accountService.yanzheng(userid)){
            response.getWriter().write("n");
        }
        else {
            response.getWriter().write("y");
        }
    }
}
