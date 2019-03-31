package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName NewBean
 * @package com.bw.yq.bean
 * @date 2019/3/29 14:09
 */
public class NewBean {
    private String message;
    private String status;

    public NewBean(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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
        return "NewBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
