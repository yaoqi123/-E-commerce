package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName OrderBean
 * @package com.bw.yq.bean
 * @date 2019/3/29 22:01
 */
public class OrderBean {
    private String status;
    private String message;

    public OrderBean(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
