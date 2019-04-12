package ssm.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.Entity.Product;
import ssm.Service.AdService;
import ssm.Service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "product")
public class listproduct {
    @Autowired
    private ProductService productService;
    @Autowired
    private AdService adService;
    @RequestMapping(path = "mainpage")
    public String listproduct_mainpage(HttpSession session){
        session.setAttribute("list_product",productService.queryrand(8));
        session.setAttribute("list_ad",adService.getrand(3));
        return "redirect:/page/shangcheng.jsp";
    }
    @RequestMapping(path = "findByKey")
    public String listproduct_key(@RequestParam(value = "search") String key,HttpSession session){
        session.setAttribute("list_product",productService.queryabout(key));
        return "redirect:/page/shangcheng.jsp";
    }
    @RequestMapping(path = "ajax")
    @ResponseBody
    public void ajax(@RequestParam(value = "search_info") String key, HttpServletResponse response) throws IOException {
        List<String> str=new ArrayList<String>();
        List<Product> productList=productService.queryabout(key);
        if(productList.size()>0){
            for(int i=0;i<productList.size();i++) {
                str.add(productList.get(i).getName());
            }
        }
        Gson gson=new Gson();
        String json=gson.toJson(str);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }
    @RequestMapping(path = "findByFenlei")
    public String listproduct_fenlei(String fenlei,HttpSession session){
        session.setAttribute("list_product",productService.query(fenlei));
        return "redirect:/page/shangcheng.jsp";
    }
    @RequestMapping(path = "one")
    public String findone(@RequestParam(value = "productid") int id, Model model){
        model.addAttribute("product",productService.query(id));
        return "forward:/page/product.jsp";
    }
    @RequestMapping(path = "quit")
    public String quitaccount(HttpServletResponse response,HttpSession session){
        session.invalidate();
        Cookie newCookie=new Cookie("cook_userid",null);      //假如要删除名称为username的Cookie
        newCookie.setMaxAge(0);             //立即删除型
        response.addCookie(newCookie);     //重新写入，将覆盖之前
        return "redirect:mainpage";
    }
}
