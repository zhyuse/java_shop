package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import snnu.zhyuse.mymail.MyMail;
import ssm.Entity.User;
import ssm.Service.AccountService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "findpassowrd")
public class findpassword {
    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "step1")
    public String step1(HttpSession session,Model model, @RequestParam(value = "id") String userid){
        if(accountService.yanzheng(userid))
        {
            MyMail myMail=new MyMail();
            session.setAttribute("userid_find",userid);
            session.setAttribute("yzm_find",myMail.send(accountService.getUser(userid).getMail()));
            model.addAttribute("step",2);
            return "forward:../page/findpassword.jsp";
        }
        else {
            model.addAttribute("msg","用户不存在");
            return "forward:../page/findpassword.jsp";
        }
    }
    @RequestMapping(path = "step2")
    public String step2(String yzm, Model model,HttpSession session){
        if(yzm.equals(session.getAttribute("yzm_find"))){
            model.addAttribute("step",3);
            return "forward:/page/findpassword.jsp";
        }
        else {
            model.addAttribute("step",2);
            model.addAttribute("msg","验证码错误");
            return "forward:/page/findpassword.jsp";
        }
    }
    @RequestMapping(path = "step3")
    public String step3(@RequestParam(value = "pd") String password,HttpSession session,Model model){
        User user=accountService.getUser((String) session.getAttribute("userid_find"));
        user.setPassword(password);
        accountService.update(user);
        model.addAttribute("msg_login","新密码修改成功");
        return "forward:/page/login.jsp";
    }
}
