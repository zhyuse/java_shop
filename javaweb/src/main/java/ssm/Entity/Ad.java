package ssm.Entity;

import java.io.Serializable;

public class Ad implements Serializable {
    private int id;
    private String image;
    private String href;

    public void setId(int id){ this.id=id; }
    public int getId()  { return id; }

    public void setImage(String image){ this.image=image; }
    public String getImage()  { return image; }

    public void setHref(String href){ this.href=href; }
    public String getHref()  { return href; }

    public Ad(int id, String image, String href) {
        this.id = id;
        this.image = image;
        this.href = href;
    }

    public Ad(){}

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
