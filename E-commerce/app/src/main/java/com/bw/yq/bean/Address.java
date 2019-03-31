package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Address
 * @package com.bw.yq.bean
 * @date 2019/3/28 20:37
 */
public class Address {

    private String address;
    private String createTime;
    private int id;
    private String phone;
    private String realName;
    private String userId;
    private int whetherDefault;
    private String zipCode;


    public Address(String address, String createTime, int id, String phone, String realName, String userId, int whetherDefault, String zipCode) {
        this.address = address;
        this.createTime = createTime;
        this.id = id;
        this.phone = phone;
        this.realName = realName;
        this.userId = userId;
        this.whetherDefault = whetherDefault;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getWhetherDefault() {
        return whetherDefault;
    }

    public void setWhetherDefault(int whetherDefault) {
        this.whetherDefault = whetherDefault;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", userId='" + userId + '\'' +
                ", whetherDefault=" + whetherDefault +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
