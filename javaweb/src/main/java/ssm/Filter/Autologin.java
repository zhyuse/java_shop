package ssm.Filter;

import org.springframework.stereotype.Controller;
import ssm.Entity.User;
import ssm.Service.AccountService;
import ssm.Service.Impl.AccountServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Autologin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 相关设置
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);

        Cookie[] cookies=request.getCookies();
        String cook_userid=null;
        String cook_userpd=null;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("cook_userid".equals(cookie.getName())){
                    cook_userid=cookie.getValue();
                }
                if("cook_userpd".equals(cookie.getName())){
                    cook_userpd=cookie.getValue();
                }
            }
        }

        //判断账户信息不为空
        if(cook_userid!=null&&cook_userpd!=null){
            AccountService accountService=new AccountServiceImpl();
//            if("登录成功！".equals(accountService.login(cook_userid,cook_userpd))){
//                User user=accountService.getUser(cook_userid);
//                session.setAttribute("user",user);
//                session.setAttribute("userid",cook_userid);
//            }    需要controller注入service，否则userdao空值
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
