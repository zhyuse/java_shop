package ssm.Entity;

import java.io.Serializable;

public class Order_list implements Serializable {
    private int id;
    private String time;
    private String userid;
    private String productname;
    private int num;
    private  double price;
    private String address;
    private String receiver;
    private int status;
    private String phone;

    public Order_list(int id, String time, String userid, String productname, int num, double price, String address, String receiver, int status, String phone) {
        this.id = id;
        this.time = time;
        this.userid = userid;
        this.productname = productname;
        this.num = num;
        this.price = price;
        this.address = address;
        this.receiver = receiver;
        this.status = status;
        this.phone = phone;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Order_list{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", userid='" + userid + '\'' +
                ", productname='" + productname + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", receiver='" + receiver + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Order_list(){}
}
