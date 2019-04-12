package ssm.Entity;

import java.io.Serializable;

public class Address implements Serializable {
    private int id;
    private String userid;
    private String address;
    private String receiver;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", address='" + address + '\'' +
                ", username='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Address(int id, String userid, String address, String receiver, String phone) {
        this.id = id;
        this.userid = userid;
        this.address = address;
        this.receiver = receiver;
        this.phone = phone;
    }

    public void setUserid(String userid) { this.userid=userid; }
    public String getUserid() {return userid;}

    public void setAddress(String address) { this.address=address; }
    public String getAddress() {return address;}

    public void setReceiver(String receiver) { this.receiver=receiver; }
    public String getReceiver() {return receiver;}

    public void setPhone(String phone) { this.phone=phone; }
    public String getPhone() {return phone;}


    public Address(){}

}
