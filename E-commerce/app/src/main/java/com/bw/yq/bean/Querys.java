package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Querys
 * @package com.bw.yq.bean
 * @date 2019/3/23 15:32
 */
public class Querys {
    private int commodityId;
    private String commodityName;
    private String masterPic;
    private String price;


    public Querys(int commodityId, String commodityName, String masterPic, String price) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
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

    @Override
    public String toString() {
        return "Querys{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
