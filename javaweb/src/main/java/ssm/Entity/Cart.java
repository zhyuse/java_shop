package ssm.Entity;

import java.io.Serializable;

public class Cart implements Serializable {
    private  String userid;
    private  int productid;
    private  String productname;
    private  int num;
    private  double danjia;
    private  double price;
    private  String image;

    public String  getUserid()   {  return userid;}
    public void setUserid(String  userid)  { this.userid=userid; }

    public int getProductid()   {  return productid;}
    public void setProductid(int productid)  { this.productid=productid; }

    public String getProductname()  {  return productname; }
    public void  setProductname(String productname)  {  this.productname=productname;}

    public int getNum()   {  return num;}
    public void setNum(int num)  { this.num=num; }

    public double getDanjia()   {  return danjia;}
    public void setDanjia(double danjia)  { this.danjia=danjia; }

    public double getPrice()   {  return price;}
    public void setPrice(double price)  { this.price=price; }

    public String  getImage()   {  return image;}
    public void setImage(String  image)  { this.image=image; }

    public Cart(String userid, int productid, String productname, int num, double danjia, double price, String image) {
        this.userid = userid;
        this.productid = productid;
        this.productname = productname;
        this.num = num;
        this.danjia = danjia;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userid='" + userid + '\'' +
                ", productid=" + productid +
                ", productname='" + productname + '\'' +
                ", num=" + num +
                ", danjia=" + danjia +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    public Cart(){}

}
