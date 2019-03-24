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
    private String price;
    private int count;

    public Result(int commodityId, String commodityName, String pic, String price, int count) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.pic = pic;
        this.price = price;
        this.count = count;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Result{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", pic='" + pic + '\'' +
                ", price='" + price + '\'' +
                ", count=" + count +
                '}';
    }
}
