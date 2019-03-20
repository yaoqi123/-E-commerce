package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Search
 * @package com.bw.yq.bean
 * @date 2019/3/19 16:45
 */
public class Search {
    private String commodityName;
    private String masterPic;
    private String price;
    private String commodityId;


    public Search(String commodityName, String masterPic, String price, String commodityId) {
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public String toString() {
        return "Search{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price='" + price + '\'' +
                ", commodityId='" + commodityId + '\'' +
                '}';
    }
}
