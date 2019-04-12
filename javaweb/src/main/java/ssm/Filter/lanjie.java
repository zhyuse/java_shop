package ssm.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class lanjie implements Filter {
    private String excludedPage;
    private String[] excludedPages;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPage = filterConfig.getInitParameter("ignores");//此处的ignores就是在web.xml定义的名称一样。
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);

        String userid= (String) session.getAttribute("userid");

        // 定义表示变量 并验证用户请求URL 是否包含不过滤路径
        boolean flag = false;
        for (String page:excludedPages) {
            if (request.getRequestURI().contains(page)||request.getRequestURI().equals("/javaweb_war_exploded/")){
                flag = true;
            }
        }
        System.out.println(userid);
        if(flag||userid!=null){     //可以免登陆进入的页面
            filterChain.doFilter(request,response);
        }
        else {                    //需要登录才能进入的页面
            request.setAttribute("msg_login","请先登录账户");
            request.getRequestDispatcher("/page/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
