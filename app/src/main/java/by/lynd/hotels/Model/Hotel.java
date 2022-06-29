package by.lynd.hotels.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hotel implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("image")
    @Expose
    private String imageUrl;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("email")
    @Expose
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
