package ssm.Entity;

import java.io.Serializable;

public class User  implements Serializable {
    private String userid;
    private String username;
    private String password;
    private String mail;

    public void setUserid(String userid) {this.userid=userid;}
    public String getUserid() { return  userid;}

    public void setUsername(String username) {this.username=username;}
    public String getUsername() { return  username;}

    public void setPassword(String password) {this.password=password;}
    public String getPassword() { return  password;}

    public void setMail(String mail) {this.mail=mail;}
    public String getMail() { return  mail;}

    public User(String userid, String username, String password, String mail) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    /**
     * 如果只加了上面那个构造器，则无法使用 User user=new User();而对于ResultSetHandler,
     * 需要调用到User user=new User()，所以在此再构造一个构造函数。
     * 对于dbutils的使用还是要多看看它的实现源码的
     */
    public User(){}


    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
