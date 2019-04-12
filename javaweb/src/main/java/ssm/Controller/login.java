package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.Service.AccountService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(path = "account")
public class login {
    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "login")
    public String login(@RequestParam(value = "id") String userid, @RequestParam(value = "password") String password,
                        String autologin , HttpServletRequest request , HttpServletResponse response, HttpSession session) throws IOException {
        switch (accountService.login(userid,password)){
            case "登录成功！":
                if(autologin!=null){
                    Cookie cookie_userid=new Cookie("cook_userid",userid);
                    Cookie cookie_userpd=new Cookie("cook_userpd",password);
                    cookie_userid.setMaxAge(60*60);//1小时
                    cookie_userpd.setMaxAge(60*60);
                    cookie_userid.setPath(request.getContextPath());
                    cookie_userpd.setPath(request.getContextPath());
                    response.addCookie(cookie_userid);
                    response.addCookie(cookie_userpd);
                }
                session.setAttribute("user",accountService.getUser(userid));
                session.setAttribute("userid",userid);
                return "redirect:/page/shangcheng.jsp";
            default:
                request.setAttribute("msg_login",accountService.login(userid,password));
                return "forward:/page/login.jsp";//redirect:../page/login.jsp
        }
    }

}
