package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Details
 * @package com.bw.yq.bean
 * @date 2019/3/19 19:12
 */
public class Details {
    private int categoryId;
    private int commodityId;
    private String picture;
    private String commodityName;
    private String price;
    private String stock;
    private String details;


    public Details(int categoryId, int commodityId, String picture, String commodityName, String price, String stock, String details) {
        this.categoryId = categoryId;
        this.commodityId = commodityId;
        this.picture = picture;
        this.commodityName = commodityName;
        this.price = price;
        this.stock = stock;
        this.details = details;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Details{" +
                "categoryId=" + categoryId +
                ", commodityId=" + commodityId +
                ", picture='" + picture + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
