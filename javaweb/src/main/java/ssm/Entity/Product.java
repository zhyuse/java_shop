package ssm.Entity;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String fenlei;
    private double price;
    private int num;
    private String jieshao;
    private String image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(int id, String name, String fenlei, Double price, int num, String jieshao, String image) {
        this.id = id;
        this.name = name;
        this.fenlei = fenlei;
        this.price = price;
        this.num = num;
        this.jieshao = jieshao;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fenlei='" + fenlei + '\'' +
                ", price='" + price + '\'' +
                ", num=" + num +
                ", jieshao='" + jieshao + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
