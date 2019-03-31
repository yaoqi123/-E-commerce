package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Result
 * @package com.bw.yq.bean
 * @date 2019/3/24 14:22
 */
public class Result {

    private int commodityId;
    private String commodityName;
    private String pic;
    private double price;
    private int count;
    private boolean isChecd;

    @Override
    public String toString() {
        return "Result{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", isChecd=" + isChecd +
                '}';
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecd() {
        return isChecd;
    }

    public void setChecd(boolean checd) {
        isChecd = checd;
    }

    public Result(int commodityId, String commodityName, String pic, double price, int count, boolean isChecd) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.pic = pic;
        this.price = price;
        this.count = count;
        this.isChecd = isChecd;
    }
}
