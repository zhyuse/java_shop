package ssm.Entity;

import java.io.Serializable;

public class Order_detail implements Serializable {
    private int id;
   // DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String time;
    private String userid;
    private int productid;
    private String productname;
    private int num;
    private double danjia;
    private  double price;
    private  String image;
    private String address;
    private String receiver;
    private int status;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getDanjia() {
        return danjia;
    }

    public void setDanjia(double danjia) {
        this.danjia = danjia;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Order_detail(int id, String time, String userid, int productid, String productname, int num, double danjia, double price, String image, String address, String receiver, int status, String phone) {
        this.id = id;
        this.time = time;
        this.userid = userid;
        this.productid = productid;
        this.productname = productname;
        this.num = num;
        this.danjia = danjia;
        this.price = price;
        this.image = image;
        this.address = address;
        this.receiver = receiver;
        this.status = status;
        this.phone = phone;
    }
    public Order_detail(){}

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", userid='" + userid + '\'' +
                ", productid=" + productid +
                ", productname='" + productname + '\'' +
                ", num=" + num +
                ", danjia=" + danjia +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", address='" + address + '\'' +
                ", receiver='" + receiver + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                '}';
    }
}
