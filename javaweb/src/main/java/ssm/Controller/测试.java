package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.Entity.Address;
import ssm.Entity.Order_detail;
import ssm.Service.*;

@Controller
@RequestMapping(path = "test")
public class 测试 {
    @Autowired
    private CartService cartService;
    @Autowired
    private Order_detailService order_detailService;
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "yes")
    public String test(){
        System.out.println(cartService.getprice("41612234"));
        order_detailService.comment("41612234",1);
        System.out.println("模糊"+productService.queryabout("苹果"));
        System.out.println("指定"+productService.query(1));
        System.out.println("分类"+productService.query("日用"));
        return "ceshi";
    }
}
